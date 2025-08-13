package lab;

import java.io.IOException;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/lotto1")
public class LottoServlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
		RequestDispatcher rd = null;;
		
		int requestNum = Integer.parseInt(request.getParameter("num"));

		Random random = new Random();
		int randomNum = random.nextInt(6)+1;   // random.nextInt(1, 7);
		
		
		System.out.printf("전달된 값 : %d, 추출된 값 : %d\n", requestNum, randomNum);

		if(requestNum == randomNum) {
			rd = request.getRequestDispatcher("/clientexam/success.html");
		}else {
			rd = request.getRequestDispatcher("/clientexam/fail.html");			
		}
		rd.forward(request, response);
		
	}

}
