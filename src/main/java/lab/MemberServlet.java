package lab;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.MemberDTO;


@WebServlet("/MemberServlet")
public class MemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
      

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
		request.setCharacterEncoding("utf-8");
		System.out.println(request.getParameter("phone"));
		
		String name = (request.getParameter("name") == null || request.getParameter("name").equals("")) ? "없음" : request.getParameter("name");
		String phone = (request.getParameter("phone") == null || request.getParameter("phone").equals("")) ? "없음" : request.getParameter("phone");
		String id = (request.getParameter("id") == null || request.getParameter("id").equals("")) ? "없음" : request.getParameter("id");
		String password = (request.getParameter("password") == null || request.getParameter("password").equals("")) ? "없음" : request.getParameter("password");
		
		
		MemberDTO dto = new MemberDTO();
		dto.setName(name);
		dto.setPhone(phone);
		dto.setId(id);
		dto.setPassword(password);
		
		request.setAttribute("member", dto);
		
		//System.out.println(dto.toString());
		request.getRequestDispatcher("/jspexam/memberView.jsp").forward(request, response);
	}

}
