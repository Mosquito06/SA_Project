package com.dgit.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.dgit.domain.UserVO;

public class LoginInterceptor extends HandlerInterceptorAdapter {
	
	private static final Logger logger = LoggerFactory.getLogger(LoginInterceptor.class);

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		
		
		Object object = modelAndView.getModel().get("login");
		Object object2 = modelAndView.getModel().get("path");
		Object object3 = modelAndView.getModel().get("query");
		HttpSession session = request.getSession();
		
		if(object != null){
			UserVO user = (UserVO) object;
			session.setAttribute("login", user);
			String path = (String) object2;
			
			if(object3 != null){
				String query = (String) object3;
				path = path + query;
			}
						
			response.sendRedirect(request.getContextPath() + "/" + path);
		}
		
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		return true;
	}
}
