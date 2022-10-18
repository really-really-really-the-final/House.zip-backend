package com.ssafy.happy.controller;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.happy.dto.User;
import com.ssafy.happy.model.service.JwtService;
import com.ssafy.happy.model.service.UserService;

@CrossOrigin(origins = { "*" }, maxAge = 6000)
// 컨트롤러 어노테이션
@RestController
// 요청을 받을 URL
@RequestMapping("/auth")
public class AuthController {

	@Autowired
	private JwtService jwtService;
	@Autowired
	private UserService userService;
	
	// 로그인 요청 처리
	@PostMapping("/login")
	public ResponseEntity<Map<String, Object>> login(@RequestBody User user, HttpServletResponse res) throws SQLException {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		HttpStatus status = null;
		try {
			// 로그인 
			User loginUser = userService.login(user.getId(), user.getPassword());
			
			// 로그인 성공했다면 토큰을 생성한다.
			String token = jwtService.createToken(loginUser);
			// 토큰 정보는 request의 헤더로 보내고 나머지는 Map에 담아주자.
			res.setHeader("jwt-auth-token", token);
			resultMap.put("auth_token", token);
			
			resultMap.put("status", true);
			resultMap.put("data", loginUser);
			status = HttpStatus.ACCEPTED;
		} catch (RuntimeException e) {
			resultMap.put("message", e.getMessage());
			resultMap.put("status", false);
			status = HttpStatus.INTERNAL_SERVER_ERROR;
		}
		return new ResponseEntity<Map<String, Object>>(resultMap, status);
	}

}
