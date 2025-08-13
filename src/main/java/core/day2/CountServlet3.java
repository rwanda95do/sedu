package core.day2;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/count3")
public class CountServlet3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		HttpSession session = request.getSession();		// getsession() : 없으면 세션만들고, 있으면 세션 줌
		
		if(session.getAttribute("cnt") == null) {
			session.setAttribute("cnt", new int[1]);		// 원소 하나짜리 객체 만들기, 참조값이 리턴됨
		}
		
		int[] count = (int[])session.getAttribute("cnt");
		count[0]++;
		out.print("<h1>세션객체</h1><hr>");	
		out.print("<h3>당신은 "+ count[0] + "번째 방문입니다.</h3>");		
		out.close();
	}
}



