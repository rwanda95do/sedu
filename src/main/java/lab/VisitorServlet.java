package lab;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/visitor")
public class VisitorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
		request.setCharacterEncoding("utf-8");
		
		PrintWriter out = response.getWriter();
		
		String name = request.getParameter("name");
		String contents = request.getParameter("contents");
		LocalDate localDate = LocalDate.now();
		
		String date = String.format("%d년%d월%d일", localDate.getYear(), localDate.getMonthValue(), localDate.getDayOfMonth());
		// String date2 = localDate.format(DateTimeFormatter.ofPattern("yyyy년MM월dd일"));
	
		
		
		out.print("<h2>" + name + "님이 " + date + "에 남긴 글입니다.</h2>");
		out.print("<hr>");
		out.print("<h3>" + contents + "</h3>");
		
	}

}
