package com.housezip.model.service;

import java.util.Date;

import javax.xml.bind.DatatypeConverter;

import org.springframework.stereotype.Component;

import com.housezip.dto.User;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtService {
	private String SECRET_KEY = "secretHousezip";
	private Long expire= 1000 * 60 * 30L;
	
	public String createToken(User user) {
		JwtBuilder builder = Jwts.builder();
		builder.setHeaderParam("typ", "JWT");
		builder.setExpiration(new Date(System.currentTimeMillis()+expire));
		builder.claim("User", user);
		builder.signWith(SignatureAlgorithm.HS256, DatatypeConverter.parseBase64Binary(SECRET_KEY));
		return builder.compact();
		
	}
	public String checkToken(String jwt) {
		System.out.println(Jwts.parser().setSigningKey(DatatypeConverter.parseBase64Binary(SECRET_KEY)).parseClaimsJws(jwt).getBody());
		return Jwts.parser().setSigningKey(DatatypeConverter.parseBase64Binary(SECRET_KEY)).parseClaimsJws(jwt).getBody().getSubject();
	}
	
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
