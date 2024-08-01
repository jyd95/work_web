package com.tenco.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

@WebServlet("/delete-post")
public class DeletePostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public DeletePostServlet() {
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8"); 
		
		String id = request.getParameter("boardId");
		System.out.println("id : " + id);
		
		try (Connection conn = DBUtill.getConnection()){
			
			String sql = " DELETE FROM posts WHERE id = ? ";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, Integer.parseInt(id));
			
			// 클라이언트에게 새로운 URL을 자동으로 요청하도록 HTTP 응답을 보낸다.
			// HTTP 상태 코드 302(임시 이동)
			response.sendRedirect("result.jsp?message=delete-success");
			
			pstmt.executeUpdate();
			response.sendRedirect("result.jsp?message=delete-error");
			} catch (Exception e) {
			
		}
		
	}
}
