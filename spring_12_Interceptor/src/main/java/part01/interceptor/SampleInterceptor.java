package part01.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/*
 * preHandle() -요청 컨트롤러에 들어가기전 접근
 * postHandle()-요청 컨트롤러 접근 후 View 페이지 접근 전
 * afterCompletion() 요청 컨트롤러 접근후 view 페이지 접근 후 response 하기 전
 * 
 */






public class SampleInterceptor implements HandlerInterceptor{
public SampleInterceptor() {
	// TODO Auto-generated constructor stub
}

@Override
public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
	// TODO Auto-generated method stub
  System.out.println("preHandle...");
	return true;
}

@Override
public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
		ModelAndView modelAndView) throws Exception {
	// TODO Auto-generated method stub
	System.out.println("postHandle...");
	
}

@Override
public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
		throws Exception {
	// TODO Auto-generated method stub
	System.out.println("afterCompletion...");
}



}
