

import java.io.IOException;
import java.io.PrintWriter;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet({"/first1", "/first2", "/first"})
public class FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	// 오버라이드 -> throws ServletException, IOException 가능,  다른 예외처리는 직접 구현
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF8");   // 서블릿 응답은 html형식이고, UTF8로 만들어진 응답  -> utf8안해주면 한글깨짐
		//response.setContentType("text/plain; charset=UTF8");   // 일반 텍스트로 인식
		//response.setContentType("test/plain; charset=UTF8");   // 잘못된 마임타입이 오니까 응답내용을 저장해버림;;;
		
		PrintWriter out = response.getWriter();    // 문자 스트림
		out.println("<h1> 현재 시간 : " + new java.util.Date() + "</h1>");
		System.out.println("서블릿에서 표준 출력해요~~~~");
		
		String name = request.getParameter("myname");
		out.println("<h2> 반가워요!!  " + name + "님 </h2>");
		
		out.close();
	}

}
