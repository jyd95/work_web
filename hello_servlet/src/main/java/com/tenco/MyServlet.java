package com.tenco;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

// http://localhost:8080/hello/myservlet
public class MyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MyServlet() {
    	super();
    	System.out.println("호출1");
    }
    
    @Override
    public void init() throws ServletException {
    	System.out.println("호출2");
    	super.init();
    }

    // 클라이언트가 매번 요청을 하는데 매번 호출이 될까?
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	System.out.println("호출3");
    	System.out.println("서비스 메서드 호출 확인");
    	response.setContentType("text/json; charset=UTF-8");
    	// 부모클래스 메서드 호출
    	super.service(request, response);
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGET 메서드 호출");
		response.setContentType("text/json; charset=UTF-8");
		response.getWriter().write("{\r\n"
				+ "  \"id\": 1,\r\n"
				+ "  \"name\": \"Leanne Graham\",\r\n"
				+ "  \"username\": \"Bret\",\r\n"
				+ "  \"email\": \"Sincere@april.biz\",\r\n"
				+ "  \"address\": {\r\n"
				+ "    \"street\": \"Kulas Light\",\r\n"
				+ "    \"suite\": \"Apt. 556\",\r\n"
				+ "    \"city\": \"Gwenborough\",\r\n"
				+ "    \"zipcode\": \"92998-3874\",\r\n"
				+ "    \"geo\": {\r\n"
				+ "      \"lat\": \"-37.3159\",\r\n"
				+ "      \"lng\": \"81.1496\"\r\n"
				+ "    }\r\n"
				+ "  },\r\n"
				+ "  \"phone\": \"1-770-736-8031 x56442\",\r\n"
				+ "  \"website\": \"hildegard.org\",\r\n"
				+ "  \"company\": {\r\n"
				+ "    \"name\": \"Romaguera-Crona\",\r\n"
				+ "    \"catchPhrase\": \"Multi-layered client-server neural-net\",\r\n"
				+ "    \"bs\": \"harness real-time e-markets\"\r\n"
				+ "  }\r\n"
				+ "}");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPOST 메서드 호출");
	}

	@Override
	public void destroy() {
		System.out.println("destroy 메서드 호출");
		super.destroy();
	}
	
}
