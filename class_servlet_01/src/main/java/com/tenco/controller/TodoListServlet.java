package com.tenco.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

@WebServlet("/todolist")

public class TodoListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public TodoListServlet() {
		super();

	}

	// GET 방식
	// http://localhost:8080/study_02/todolist
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 다시 HTML 형식을 만들어서 클라이언트에게 내려주는 것은
		// 서블릿 에서 너무 불편하다.
		// 서블릿 컨텍스트라는 객체를 활용해서 코드를 만들어 보자.

		response.setContentType("text/html; charset=UTF-8");

		// HTML 파일 읽기
		String htmlFilePath = "/todoList01.html";
		InputStream is = getServletContext().getResourceAsStream(htmlFilePath);
		if (is == null) {
			response.getWriter().write("<html><body>해당 파일을 찾을 수 없음. 404error</body></html>");
		}
		
		BufferedReader br = new BufferedReader(new InputStreamReader(is));
		StringBuffer htmlContent = new StringBuffer();
		String line;
		while( (line =br.readLine()) != null ) {
			htmlContent.append(line);
		}
		br.close();
		
		response.getWriter().write(htmlContent.toString());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
