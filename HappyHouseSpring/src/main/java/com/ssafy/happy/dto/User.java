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
	String interestSidoCode;
	String interestGugunCode;
	public User(String id, String password, String name, String email, String tel, String category,
			String interestSidoCode, String interestGugunCode) {
		this.id = id;
		this.password = password;
		this.name = name;
		this.email = email;
		this.tel = tel;
		this.isManager = false;
		this.category=category;
		this.interestSidoCode=interestSidoCode;
        this.interestGugunCode=interestGugunCode;
	}
	
	public User(String interestSidoCode, String interestGugunCode) {
		this.interestSidoCode=interestSidoCode;
        this.interestGugunCode=interestGugunCode;
	}
	
}

