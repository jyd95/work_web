package com.tenco.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class UserDAOImpl implements UserDAO {

	private DataSource dataSource;

	public UserDAOImpl() {

		try {
			InitialContext ctx = new InitialContext();
			dataSource = (DataSource) ctx.lookup("java:comp/env/jdbc/MyDB");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}

	@Override
	public int addUser(UserDTO userDTO) {
		int resultCount = 0;
		String sql = " INSERT INTO users(username, password, email) values(?, ?, ?) ";

		try (Connection conn = dataSource.getConnection()) {
			// 트랜젝션 시작
			conn.setAutoCommit(false);
			try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
				pstmt.setString(1, userDTO.getUsername());
				pstmt.setString(2, userDTO.getPassword());
				pstmt.setString(3, userDTO.getEmail());
				resultCount = pstmt.executeUpdate();
				// 트랜젝션 커밋
				conn.commit();
			} catch (Exception e) {
				conn.rollback();
				e.printStackTrace();
			} // end of preparedstatement
			System.out.println("resultCount : " + resultCount);
		} catch (SQLException e) {
			e.printStackTrace();
		} // end of Connection

		return resultCount;
	}

	/*
	 * SELECT 에서는 일단 트랜젝션 처리 보류 하지만 팬텀 리드 현상( 정합성을 위해서 처리 하는 것도 옳은 방법이다. )
	 */

	@Override
	public UserDTO getUserById(int id) {

		String sql = " select * from users where id = ? ";
		UserDTO userDTO = null;

		try (Connection conn = dataSource.getConnection()) {
			conn.setAutoCommit(false);
			try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
				pstmt.setInt(1, id);
				ResultSet rs = pstmt.executeQuery();
				if (rs.next()) {
					userDTO = new UserDTO();
					userDTO.setId(rs.getInt("id"));
					userDTO.setUsername(rs.getString("username"));
					userDTO.setPassword(rs.getString("password"));
					userDTO.setEmail(rs.getString("email"));
					userDTO.setCreatedAt(rs.getString("created_at"));
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("UserDTO by Id: " + userDTO.toString());
		return userDTO;
	}

	@Override
	public UserDTO getUserByUsername(String username) {

		String sql = " select * from users where username = ? ";
		UserDTO userDTO = null;

		try (Connection conn = dataSource.getConnection()) {
			conn.setAutoCommit(false);
			try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
				pstmt.setString(1, username);
				ResultSet rs = pstmt.executeQuery();
				if (rs.next()) {
					userDTO = new UserDTO();
					userDTO.setId(rs.getInt("id"));
					userDTO.setUsername(rs.getString("username"));
					userDTO.setPassword(rs.getString("password"));
					userDTO.setEmail(rs.getString("email"));
					userDTO.setCreatedAt(rs.getString("created_at"));
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
			// TODO - 삭제 예정
			System.out.println("UserDTO By Username: " + userDTO.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return userDTO;
	}

	@Override
	public List<UserDTO> getAllUsers() {
		String sql = " select * from users ";
		// 자료구조를 사용할 때 일단 생성시키고 시작하자.
		List<UserDTO> list = new ArrayList();

		try (Connection conn = dataSource.getConnection()) {
			conn.setAutoCommit(false);
			try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
				ResultSet rs = pstmt.executeQuery();
				while (rs.next()) {
					UserDTO userDTO = new UserDTO();
					userDTO.setId(rs.getInt("id"));
					userDTO.setUsername(rs.getString("username"));
					userDTO.setPassword(rs.getString("password"));
					userDTO.setEmail(rs.getString("email"));
					userDTO.setCreatedAt(rs.getString("created_at"));
					list.add(userDTO);
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("UserList All : " + list.toString());

		return list;
	}

	@Override
	public int updateUser(UserDTO userDTO, int principalId) {
		String sql = " update users set password = ?, email = ? where id = ? ";
		int rowCount = 0;
		try (Connection conn = dataSource.getConnection()) {
			conn.setAutoCommit(false);
			try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
				pstmt.setString(1, userDTO.getPassword());
				pstmt.setString(2, userDTO.getEmail());
				pstmt.setInt(3, principalId);
				rowCount = pstmt.executeUpdate();
				conn.commit();
			} catch (Exception e) {
				conn.rollback();
				e.printStackTrace();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return rowCount;
	}

	@Override
	public int deleteUser(int id) {
		String sql = " delete from users where id = ? ";
		int rowCount = 0;
		try (Connection conn = dataSource.getConnection()) {
			conn.setAutoCommit(false);
			try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
				pstmt.setInt(1, id);
				rowCount = pstmt.executeUpdate();
				conn.commit();

			} catch (Exception e) {
				conn.rollback();
				e.printStackTrace();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return rowCount;
	}
}
