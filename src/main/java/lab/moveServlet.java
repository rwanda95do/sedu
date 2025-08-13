package lab;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/move")
public class moveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		try {			
			String action = request.getParameter("action");
			
			if(action == null) {
				out.print("<h2>전달된 쿼리 문자열이 없어서 MoveServlet이 직접 응답합니다.</h2>");									
			}
			
			if(action.equals("naver")) {
				response.sendRedirect("https://www.naver.com/");
			}else if(action.equals("daum")) {
				response.sendRedirect("https://www.daum.net/");
			}else if(action.equals("google")) {			
				response.sendRedirect("https://www.google.com/");
			} else {
				out.print("<h2>전달된 쿼리 문자열이 없어서 MoveServlet이 직접 응답합니다.</h2>");						
			}
			
		} catch (NullPointerException e) {}
		
		out.close();
	}
}
