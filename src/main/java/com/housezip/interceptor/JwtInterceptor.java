package com.housezip.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import com.housezip.AuthorizationExtractor;
import com.housezip.model.service.JwtService;

@Component
public class JwtInterceptor implements HandlerInterceptor {

	@Autowired
	private JwtService jwtService;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		String token = AuthorizationExtractor.extract(request, "Bearer");
		 if (token.isEmpty()) {
	            throw new IllegalArgumentException("토큰비어있음");
	        }

		if (!jwtService.validateToken(token)) {
			throw new IllegalArgumentException("유효하지 않은 토큰");
		}
		String username = jwtService.checkToken(token);
		return true;
	}
}
