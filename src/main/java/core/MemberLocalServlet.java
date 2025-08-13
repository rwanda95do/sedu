package core;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/MemberLocal")    // URL매핑 정보
public class MemberLocalServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	// 최초요청시 생성되서 객체가 메모리에서 사라지지 않음
	int member_v = 0;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		// 지역변수 : 메소드가 호출될때마다 생성 
		int local_v = 0;
		member_v++;
		local_v++;
		out.print("<h2>member_v(멤버변수) : " + member_v + "</h2>");
		out.print("<h2>local_v(지역변수) : " + local_v + "</h2>");
		
	}

}
