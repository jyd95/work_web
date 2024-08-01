package com.tenco.controller;

import java.io.IOException;

import com.tenco.model.UserDAO;
import com.tenco.model.UserDAOImpl;
import com.tenco.model.UserDTO;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

// 주소 설계 
// http://localhost:8080/mvc/user
// http://localhost:8080/mvc/user/xxx
@WebServlet("/user/*")
public class UserController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private UserDAO userDAO;

	@Override
	public void init() throws ServletException {
		userDAO = new UserDAOImpl();
	}

	public UserController() {
	}

	// http://localhost:8080/mvc/user/signUp
	// http://localhost:8080/mvc/user/signIn
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getPathInfo();
		System.out.println("action : " + action);
		switch (action) {
		case "/signIn": {
			// 로그인 페이지로
			request.getRequestDispatcher("/WEB-INF/views/signIn.jsp").forward(request, response);
			break;
		}
		case "/signUp": {
			// 회원가입 페이지로
			request.getRequestDispatcher("/WEB-INF/views/signUp.jsp").forward(request, response);
			break;
		}
		default:
			response.sendError(HttpServletResponse.SC_NOT_FOUND);
			break;
		}
	}

	// 로그인 기능 요청 (자원 요청이므로 GET이 적합하지만 보안 때문에 예외적으로 POST방식 사용)
	// POST요청시 - 로그인 기능 구현, 회원 가입 기능 구현

	// http://localhost:8080/mvc/user/signUp
	// http://localhost:8080/mvc/user/signIn
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getPathInfo();
		System.out.println("action : " + action);
		switch (action) {
		case "/signIn": {
			signIn(request, response);
			break;
		}
		case "/signUp": {
			signUp(request, response);
			break;
		}
		default:
			response.sendError(HttpServletResponse.SC_NOT_FOUND);
			break;
		}
	}

	/*
	 * 로그인 처리 기능
	 * 
	 * @param request
	 * 
	 * @param response
	 */

	private void signIn(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// URL, 인증검사, 유효성 검사, 서비스 로직, DAO --> 전달, 뷰 호출
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		if (username == null || password.trim().isEmpty()) {
			response.sendRedirect("signIn?message=invalid");
			return;
		}

		// 유효성 검사 생략..

		UserDTO user = userDAO.getUserByUsername(username);
		// null => 회원가입이 안된 사용자.
		if (user != null && user.getPassword().equals(password)) {
			HttpSession session = request.getSession();
			session.setAttribute("principal", user);
			response.sendRedirect("/mvc/todo/todoForm");
		} else {
			response.sendRedirect("signIn?message=invalid");
		}

		// 비밀번호 == dto.getPassword로 비교

	}

	/*
	 * 회원 가입 기능
	 * 
	 * @param request
	 * 
	 * @param response
	 */
	private void signUp(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// 로그인 인증 검사가 필요 없는 기능

		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String email = request.getParameter("email");

		// 방어적 코드 작성
		if (username == null || username.trim().isEmpty()) {
			request.setAttribute("errorMessage", "사용자 이름을 입력하시오.");
			request.getRequestDispatcher("/WEB-INF/views/signUp.jsp").forward(request, response);
			return;
		}
		// 방어적 코드 작성 (password) - 생략
		// 방어적 코드 작성 (email) - 생략

		UserDTO userDTO = UserDTO.builder().username(username).password(password).email(email).build();

		int resultRowCount = userDAO.addUser(userDTO);
		System.out.println("resultRowCount : " + resultRowCount);
		if (resultRowCount == 1) {
			response.sendRedirect("/mvc/user/signIn?message=success");
		} else {
			response.sendRedirect("/mvc/user/signUp?message=error");
		}
	}
}
