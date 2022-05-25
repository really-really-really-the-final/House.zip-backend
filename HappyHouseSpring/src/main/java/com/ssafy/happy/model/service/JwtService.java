package com.ssafy.happy.model.service;

import java.util.Date;
import java.util.Map;

import javax.xml.bind.DatatypeConverter;

import org.springframework.stereotype.Component;

import com.ssafy.happy.dto.User;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtService {
	// 토큰 암호 키
	private String SECRET_KEY = "secret";
	// 토큰 만료시간 30분 설정
	private Long expire= 1000 * 60 * 30L;
	
	public String createToken(User user) {
//		byte[] secretKeyBytes = DatatypeConverter.parseBase64Binary(SECRET_KEY);
		JwtBuilder builder = Jwts.builder();
		// 토큰의 헤더 정보 입력
		builder.setHeaderParam("typ", "JWT");
		// 만료시간 담기
		builder.setExpiration(new Date(System.currentTimeMillis()+expire));		
		// User 정보 담기
		builder.claim("User", user);
		// 해당 알고리즘과 키를 이용하여 서명
		builder.signWith(SignatureAlgorithm.HS256, DatatypeConverter.parseBase64Binary(SECRET_KEY));
		
		// 직렬화 처리
		return builder.compact();
		
	}
	//토큰에서 값 추출

	// 전달받은 토큰이 제대로 생성되지 않았다면 Runtime 예외를 발생한다.
	public String checkToken(String jwt) {
		System.out.println(Jwts.parser().setSigningKey(DatatypeConverter.parseBase64Binary(SECRET_KEY)).parseClaimsJws(jwt).getBody());
		return Jwts.parser().setSigningKey(DatatypeConverter.parseBase64Binary(SECRET_KEY)).parseClaimsJws(jwt).getBody().getSubject();
	}
	
	// JWT 토큰을 분석해 필요한 정보를 반환한다.//유효한 토큰인지 확인
	   public boolean validateToken(String jwt) {
		Jws<Claims> claims = null;
		try {
			claims = Jwts.parser().setSigningKey(DatatypeConverter.parseBase64Binary(SECRET_KEY)).parseClaimsJws(jwt);
			return !claims.getBody().getExpiration().before(new Date());
		}catch (Exception e) {
			 return false;
		}
	}

}
