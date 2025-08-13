package lab;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/lotto3")
public class LottoServlet3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	// 수정할 일이 생길 수 있으니까 final static 변수로 선언
	private static final int MIN_LOTTO_NUM = 1;
	private static final int MAX_LOTTO_NUM = 6;
	private static final int MAX_ATTEMPTS = 3;  // 최대 시도 횟수
	

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
		
		int requestNum = Integer.parseInt(request.getParameter("num"));

		Random random = new Random();
		int randomNum = random.nextInt(MAX_LOTTO_NUM) + MIN_LOTTO_NUM;   // random.nextInt(1, 7); 또는 (int)(Math.random()*6) +1;
		
		System.out.printf("전달된 값 : %d, 추출된 값 : %d\n", requestNum, randomNum);


		HttpSession session = request.getSession();   // 세션 객체 준비
		
		if(session.getAttribute("count")== null) {    // 최초 요청, count라는 이름으로 보관된것이 null이니?
			session.setAttribute("count", new int[1]);
		}
		
		int [] count = (int[]) session.getAttribute("count");
		count[0]++;
	
		
		Map<String, String> map = new HashMap<String, String>();
		if(count[0] <= MAX_ATTEMPTS) {
			if(requestNum == randomNum) {
				map.put("msg", "당첨~~~ 추카추카");
				map.put("imginfo", "https://png.pngtree.com/png-vector/20221022/ourlarge/pngtree-man-and-woman-winning-jackpot-on-lottery-png-image_6337194.png");
				request.setAttribute("map", map);
			}else {
				map.put("msg", "실패~~~ 아쉽아쉽");
				map.put("imginfo", "https://item.kakaocdn.net/do/330d797cf3216a7070d511a4b3df25aef43ad912ad8dd55b04db6a64cddaf76d");
				request.setAttribute("map", map);
			}
		} else {
			map.put("msg", "더 이상 응모할 수 없어요");
			map.put("imginfo", null);			
			request.setAttribute("map", map);
		}
		request.getRequestDispatcher("/jspexam/lottoResult.jsp").forward(request, response);
		
	}

}
