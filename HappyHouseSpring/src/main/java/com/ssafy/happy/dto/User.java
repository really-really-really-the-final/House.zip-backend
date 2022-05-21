package com.ssafy.happy.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class User{
	String id;
	String password;
	String name;
	String email;
	String tel;
	boolean isManager;
	String category;
	public User(String id, String password, String name, String email, String tel, String category) {
		super();
		this.id = id;
		this.password = password;
		this.name = name;
		this.email = email;
		this.tel = tel;
		this.isManager = false;
		this.category=category;
	}
	
}

