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


@WebServlet("/reservation")
public class ReservationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
		request.setCharacterEncoding("utf-8");
		
		PrintWriter out = response.getWriter();
		
		String name = request.getParameter("name");
		String room = request.getParameter("room");
		String[] inquir = request.getParameterValues("inquir");
		LocalDate localdate = LocalDate.parse(request.getParameter("date"),DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		//String date = localdate.format(DateTimeFormatter.ofPattern("yyyy년 MM월 dd일"));
		String date = String.format("%d년%d월%d일", localdate.getYear(), localdate.getMonthValue(), localdate.getDayOfMonth());
 		
	
		out.print("<h1>"+ name + "님의 예약 내용</h1>");
		out.print("<hr>");
		out.print("<ul>"
				+ "<li>선택한 룸 :" + room + "</li>");
		out.print("<li>추가 요청 사항 :");
		for(int i=0; i<inquir.length; i++) {
			if(i==inquir.length-1 ) {
				out.print(inquir[i]);				
			}else {
				out.print(inquir[i] + ",");	
			}
		};
		out.print("</li>");
		out.print(String.format("<li>예약 날짜 : %tY년 %tm월 %td일</li>", localdate, localdate, localdate));
		out.print("<li>예약 날짜 :" + date + "</li>"
				+ "</ul>");
	}

}
