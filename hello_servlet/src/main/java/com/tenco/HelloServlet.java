package com.tenco;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/*
 * HttpServlet 클래스를 상속 받아 내가 정의한 클래스가 선언이 된다.
 * 왜냐하면 HTTP 프로토콜을 통한 request, respons 처리를 할 수 있기 떄문.
 * 
 * URL 맵핑에 대한 개념을 알자.
 * 클라이언트가 특정 URL을 요청했을 때 해당 URL에 대응하는 서블릿을
 * 실행하도록 설정하는 것을 의미.
 * URL 맵핑하는 2가지 방법 = @WebServlet 사용 또는 /  web.xml 에 서블릿 매핑 꺽쇠 안에 기술 
 */

@WebServlet(urlPatterns = {"/example"}, loadOnStartup = 1)
public class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	// 생성자
    public HelloServlet() {
    	super();
    	System.out.println("김호출1");
        System.out.println("생성자가 호출됨");
    }
    // 해당 서블릿 클래스가 인스턴스화 될 때 단 한번 실행하는 메서드
	public void init(ServletConfig config) throws ServletException {
		System.out.println("김호출2");
		System.out.println("init 메서드가 호출됨");
	}
	// 해당 서블릿 클래스가 메모리에서 내려가기 직전에 호출되는 메서드이다. 자원닫는용
	public void destroy() {
		super.destroy();
		System.out.println("destroy 메서드가 호출됨");
	}
	
	// GET 요청으로 들어왔을 때 동작됨.
	// 주소 설계 - http://localhost:8080/hello/hello-servlet
	// 의미 해석 - http:// ip주소 : 포트번호 / 컨텍스트루트/ url맵핑
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// MIME TYPE - 인터넷 세상에서 데이터의 유형을 나타내는 표준 방식
		System.out.println("김호출3");
		response.setContentType("application/pdf");
		response.setCharacterEncoding("UTF-8");
		// 스트림을 어디서 뽑아야 할까?
		response.getWriter().write("<html><body><h1>HELLO THANK TAKE CARE SEE YOU AGAIN</h1></body></html>");
		
	}

	
	// POST 요청으로 들어왔을 때 동작됨
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 문제 -> post 요청이 들어오는것을 확인 하고
		// 응용해서 데이터 또는 HTML 형식으로 응답처리 하시오!
		System.out.println("POST 요청 확인");
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write("<!DOCTYPE html>");
		response.getWriter().write("<html lang=\"en\">");
		response.getWriter().write("<head>");
		response.getWriter().write("<meta charset=\"UTF-8\">");
		response.getWriter().write("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">");
		response.getWriter().write("<title>Document</title>");
		response.getWriter().write("</head>");
		response.getWriter().write("<body>");
		response.getWriter().write("<section>");
		response.getWriter().write("<p><h1>플라워 - Endless</h1></p>");
		response.getWriter().write("<i>널 사랑해 눈을 감아도\r\n"
				+ "            단 한 번만 볼 수 있다면\r\n"
				+ "            하늘이여, 내 모든 걸 가져가\r\n"
				+ "            미련 없이 이 세상 떠나갈게\r\n"
				+ "            안녕\r\n"
				+ "            다시 돌아올까 봐\r\n"
				+ "            아직도 혼자인 거니?\r\n"
				+ "            서로가 사랑하고 있지만\r\n"
				+ "            우리는 인연이 아닌가 봐\r\n"
				+ "            많이 야윈 것 같아\r\n"
				+ "            웃음도 잃어버리고\r\n"
				+ "            항상 멀리서 널 지켜 봤어\r\n"
				+ "            아프진 않은지 너무나 걱정돼\r\n"
				+ "            기다릴게 죽는 날까지\r\n"
				+ "            나 없다고 혼자 울지 마\r\n"
				+ "            너의 눈물 위로할 수 있도록\r\n"
				+ "            그날까지만 참고 견뎌야 해\r\n"
				+ "            사랑해 눈을 감아도\r\n"
				+ "            단 한 번만 볼 수 있다면\r\n"
				+ "            하늘이여, 내 모든 걸 가져가\r\n"
				+ "            미련 없이 이 세상 떠나갈게\r\n"
				+ "            안녕\r\n"
				+ "            기다릴게 죽는 날까지\r\n"
				+ "            나 없다고 혼자 울지마\r\n"
				+ "            너의 눈물 위로할 수 있도록\r\n"
				+ "            그날까지만 참고 견뎌야 해\r\n"
				+ "            사랑해 눈을 감아도\r\n"
				+ "            단 한 번만 볼 수 있다면\r\n"
				+ "            하늘이여, 내 모든 걸 가져가\r\n"
				+ "            미련 없이 이 세상 떠나갈게\r\n"
				+ "            안녕</i>");
		response.getWriter().write("");
		response.getWriter().write("");
		response.getWriter().write("");
		response.getWriter().write("</section>");
		response.getWriter().write("</body>");
		response.getWriter().write("</html>");
		
	}

	
	
}
