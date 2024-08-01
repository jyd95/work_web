package com.tenco.model;

import java.util.List;

public interface UserDAO {
	
	int addUser(UserDTO userDTO);
	UserDTO getUserById(int id);
	UserDTO getUserByUsername(String username);
	List<UserDTO> getAllUsers();
	int updateUser(UserDTO userDTO, int principalId); 
	// principalId = 권한 (내 정보 변경 -> 나만 가능해야함) - 인증 (세션ID)
	int deleteUser(int id);
}
