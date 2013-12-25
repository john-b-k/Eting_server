package com.gif.eting.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class CommonInterceptor extends HandlerInterceptorAdapter {
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {

		// session검사
		HttpSession session = request.getSession(false);

		if (session == null) {
			// 처리를 끝냄 - 컨트롤로 요청이 가지 않음.
			request.getRequestDispatcher("/login").forward(request, response);
			return false;
		}

		String userId = (String) session.getAttribute("userId");
		if (userId == null) {
			request.getRequestDispatcher("/login").forward(request, response);
			return false;
		}
		return true;
	}

}
