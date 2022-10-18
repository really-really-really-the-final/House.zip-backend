package com.housezip.controller;

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

import com.housezip.dto.User;
import com.housezip.model.service.JwtService;
import com.housezip.model.service.UserService;

@CrossOrigin(origins = { "*" }, maxAge = 6000)
@RestController
@RequestMapping("/auth")
public class AuthController {

	@Autowired
	private JwtService jwtService;
	@Autowired
	private UserService userService;
	
	@PostMapping("/login")
	public ResponseEntity<Map<String, Object>> login(@RequestBody User user, HttpServletResponse res) throws SQLException {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		HttpStatus status = null;
		try {
			User loginUser = userService.login(user.getId(), user.getPassword());
			String token = jwtService.createToken(loginUser);
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
