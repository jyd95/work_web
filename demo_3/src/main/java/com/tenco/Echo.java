 package com.tenco;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

// 요청이 오면 응답을 한다는 개념이 핵심임.
@WebServlet(name = "echo", urlPatterns = { "/echo" })
public class Echo extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public Echo() {
        super();
    }

    @Override
    public void init() throws ServletException {
        System.out.println("Echo 서블릿 클래스가 --> 컴파일 -->.class 파일로 변환");
        System.out.println("init() 메서드는 인스턴스화 될 때 딱 한번 호출되는 메서드");
        // init 메서드 호출 = 메모리에 올라갔음. Get 요청임.
        // 요청될 때 새로 스레드가 생성되서 동작함. (멀티 스레딩)

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.getWriter().append("Served at: ").append(request.getContextPath());
        // init 메서드 호출 안 하고 재사용함. => 똑같은 내용이 출력됨.
    }

    // POST 요청 시 동작하는 메서드
    // 주소 설계
    // http://localhost:8080/demo_3/echo
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("안녕 서버측 콘솔에서 출력을 합니다.");
    }

    @Override
    public void destroy() {
        System.out.println("메모리에서 내려갈 때 호출되는 메서드");
        // 웹브라우저 끄면 이 메서드가 동작하지 않음 -> 쓰는 사람이 없으면 자동으로 됨.
    }

} 