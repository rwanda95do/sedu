package core.day2;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/forward")
public class ForwardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("ForwardServlet 수행");
		RequestDispatcher rd = 
				request.getRequestDispatcher("/first.jsp"); // 상대 URI , contextURL을 빼고 줘야함-> /sedu/first.jsp라고 하면 안됨
		/*
		RequestDispatcher rd = 
				request.getRequestDispatcher("http://www.naver.com/");
		*/
		rd.forward(request,  response);
	}
}







