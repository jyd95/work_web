package com.tenco.model;

import java.util.List;

public interface TodoDAO {
	void addTodo(TodoDTO dto, int principalId);
	TodoDTO getTodoById(int id);
	List<TodoDTO> getTodosByUserId(int userId);
	List<TodoDTO> getAllTodos();
	void updateTodo(TodoDTO dto, int principalId);
	void deleteTodo(int id, int principalId);
}
