package filter;

import java.io.IOException;

import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

@WebFilter(dispatcherTypes = {DispatcherType.REQUEST }   // DispatcherType.REQUEST 가 기본
					, urlPatterns = { "/*" })

public class HangulFilter implements Filter {
	public void destroy() {
		// TODO Auto-generated method stub
	}
	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println("한글필터 실행");
		if(((HttpServletRequest)request).getMethod().equals("POST"))
			request.setCharacterEncoding("UTF-8");
		chain.doFilter(request, response);		
	}
	
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}

/*
 * 사용하지 않는 init(), destroy()를 오버로딩 해논이유는
 * 예전에는 필수로 구현해야했지만
 * default로 바뀌었기 떄문에 지금은 오버라이딩 할 필요가 없다 -> 인터페이스 부분을 다시 공부하면 확인가능
 * */
