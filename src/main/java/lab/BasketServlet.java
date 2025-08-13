package lab;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.ProductDTO;


@WebServlet("/basket")
public class BasketServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				
		String pid = request.getParameter("pid");
		
		
		// 일정 시간동안 유지 > HttpSession
		HttpSession session = request.getSession();
		
		if(session.getAttribute("product") == null) {
			session.setAttribute("product", new ArrayList<ProductDTO>());
		}
		
		
		@SuppressWarnings("unchecked")
		List<ProductDTO> list = (ArrayList<ProductDTO>) session.getAttribute("product");

		boolean found = false;
		
		for(ProductDTO d : list) { // 강화For문은 무조껀 elements가 있어야지 수행 -> 일반for문의 배열 길이로 돌리는 방법으로 사용
			if(d.getProductName().equals(pid)) {
				d.plusCount();
				found= true;
				break;
			}
		}
		if(!found) {
			ProductDTO dto = new ProductDTO();
			dto.setProductName(pid);
			dto.plusCount();
			list.add(dto);				
		}

	
		
		
		// 상품 비우기
		String referer = request.getHeader("Referer");
		System.out.println("Referer: " + referer);
		
		if(referer.contains("sedu/basket")) {
			session.removeAttribute("product");
		}
		
		
		
		// ...  
		request.getRequestDispatcher("/jspexam/basketResult.jsp").forward(request, response);
	}

}
