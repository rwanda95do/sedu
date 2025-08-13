package core;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/FlowServlet")
public class FlowServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void init(ServletConfig config) throws ServletException {
		System.out.println("init() 메서드 호출, 최초 한번 수행 ");
	}

	public void destroy() {
		System.out.println("detroy() 메서드 호출, 객체 종료시 ");
	}


	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// reload(객체 상태를 해제한다), server가 죽을때
		System.out.println("service() 메소드 호출, 요청시마다");
	}

}
