package com.ssafy.happy.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import com.ssafy.happy.AuthorizationExtractor;
import com.ssafy.happy.model.service.JwtService;

@Component
public class JwtInterceptor implements HandlerInterceptor {
//	private static final String HEADER_AUTH = "jwt-auth-token";
//	private static final Logger logger = LoggerFactory.getLogger(JwtInterceptor.class);
	@Autowired
	private JwtService jwtService;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println(">>> interceptor.preHandle 호출");
		String token = AuthorizationExtractor.extract(request, "Bearer");
//		System.out.println(request);
//		System.out.println("~~~~~~~~~~~~~~");
//		System.out.println(token);
		 if (token.isEmpty()) {
	            throw new IllegalArgumentException("토큰비어있음");
	        }

		if (!jwtService.validateToken(token)) {
			throw new IllegalArgumentException("유효하지 않은 토큰");
		}
		
		String username = jwtService.checkToken(token);
		System.out.println(username);
//        request.setAttribute("username", username);
		return true;
	}
}
