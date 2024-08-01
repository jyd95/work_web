package com.tenco.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class TodoDAOImpl implements TodoDAO {

	private DataSource dataSource;

	public TodoDAOImpl() {

		try {
			InitialContext ctx = new InitialContext();
			dataSource = (DataSource) ctx.lookup("java:comp/env/jdbc/MyDB");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void addTodo(TodoDTO dto, int principalId) {

		String sql = " INSERT INTO todos(user_id, title, description, due_date, completed)" + " values(?, ?, ?, ?, ?) ";
		try (Connection conn = dataSource.getConnection()) {
			conn.setAutoCommit(false);

			try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
				pstmt.setInt(1, principalId);
				pstmt.setString(2, dto.getTitle());
				pstmt.setString(3, dto.getDescription());
				pstmt.setString(4, dto.getDueDate());		
				pstmt.setInt(5, dto.getCompleted() == "true" ? 1 : 0);
				pstmt.executeUpdate();
				conn.commit();
			} catch (Exception e) {
				conn.rollback();
				e.printStackTrace();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public TodoDTO getTodoById(int id) {

		String sql = " select * from todos where id = ? ";
		TodoDTO todo = null;
		try (Connection conn = dataSource.getConnection()) {
			try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
				pstmt.setInt(1, id);
				try (ResultSet rs = pstmt.executeQuery()) {
					
					if (rs.next()) {
						todo = new TodoDTO();
						todo.setId(rs.getInt("id"));
						todo.setTitle(rs.getString("title"));
						todo.setDescription(rs.getString("description"));
						todo.setDueDate(rs.getString("due_date"));
						todo.setCompleted(rs.getString("completed"));
						todo.setUserId(rs.getInt("user_id"));
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		// System.out.println("TodoDTO by Id : " + todo.toString());
		return todo;
	}

	@Override
	public List<TodoDTO> getTodosByUserId(int userId) {
		String sql = " select * from todos where user_id = ? ";
		List<TodoDTO> list = new ArrayList<>();
		try (Connection conn = dataSource.getConnection()) {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, userId);
			try (ResultSet rs = pstmt.executeQuery()) {
				while (rs.next()) {
					TodoDTO todo = new TodoDTO();
					todo.setId(rs.getInt("id"));
					todo.setTitle(rs.getString("title"));
					todo.setDescription(rs.getString("description"));
					todo.setDueDate(rs.getString("due_date"));
					todo.setCompleted(rs.getString("completed"));
					todo.setUserId(rs.getInt("user_id"));
					list.add(todo);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

	@Override
	public List<TodoDTO> getAllTodos() {
		String sql = " select * from todos ";
		List<TodoDTO> list = new ArrayList<>();
		try (Connection conn = dataSource.getConnection()) {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			try (ResultSet rs = pstmt.executeQuery()) {
				while (rs.next()) {
					TodoDTO todo = new TodoDTO();
					todo.setId(rs.getInt("id"));
					todo.setTitle(rs.getString("title"));
					todo.setDescription(rs.getString("description"));
					todo.setDueDate(rs.getString("due_date"));
					todo.setCompleted(rs.getString("completed"));
					todo.setUserId(rs.getInt("user_id"));
					list.add(todo);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

	@Override
	public void updateTodo(TodoDTO dto, int principalId) {
		String sql = " update todos set title = ?, description = ?,"
				+ " due_date = ?, completed = ?"
				+ " where id = ? and user_id = ? ";
		try (Connection conn = dataSource.getConnection()) {
			conn.setAutoCommit(false);
			try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
				pstmt.setString(1, dto.getTitle());
				pstmt.setString(2, dto.getDescription());
				pstmt.setString(3, dto.getDueDate());
				pstmt.setInt(4, dto.getCompleted() == "true" ? 1 : 0);
				pstmt.setInt(5, dto.getId());
				pstmt.setInt(6, principalId);
				pstmt.executeUpdate();
				System.out.println("커밋전");
				conn.commit();
				System.out.println("커밋후");
			} catch (Exception e) {
				System.out.println("롤백으로옴");
				conn.rollback();
				e.printStackTrace();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return;

	}
	
	/**
	 * 삭제 기능
	 * @param id : todos PK
	 * @param principalId : session ID
	 */
	@Override
	public void deleteTodo(int id, int principalId) {
		String sql = " delete from todos where id = ? and user_id = ? ";
		try (Connection conn = dataSource.getConnection()) {
			conn.setAutoCommit(false);
			try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
				pstmt.setInt(1, id);
				pstmt.setInt(2, principalId);
				pstmt.executeUpdate();
				conn.commit();
			} catch (Exception e) {
				conn.rollback();
				e.printStackTrace();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return;
	}

}
