package controller;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.CountDTO;



@WebServlet("/sharetest3")
public class ShareTestServlet3 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int param = Integer.parseInt(request.getParameter("num"));
		
		ServletContext context = getServletContext();
		if(context.getAttribute("objapp")== null) {
			context.setAttribute("objapp", new CountDTO());
		}
		
		CountDTO dto = (CountDTO)context.getAttribute("objapp");
		dto.setNumber(param);
		
		request.getRequestDispatcher("/jspexam/share3.jsp").forward(request, response);
		
	}

}


// Application Scope -> ServletContext 객체 정보 전달 