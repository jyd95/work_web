package com.tenco.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

@WebServlet("/read-posts")
public class ReadPostsServelt extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ReadPostsServelt() {
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		// 응답 처리 MIME TYPE 설정
		response.setContentType("text/html;charset=UTF-8");
		
		try (Connection conn = DBUtill.getConnection()){
			String sql = " SELECT * FROM posts ORDER BY created_at DESC ";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			
			request.setAttribute("resultSet", rs);
			request.getRequestDispatcher("readPost.jsp").forward(request, response);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
