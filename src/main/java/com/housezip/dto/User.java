package com.housezip.dto;

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
	boolean isReview;
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
	
	public User(String id, String name, String email) {
		this.id = id;
		this.name = name;
		this.email = email;
	}
	
	public User(String interestSidoCode, String interestGugunCode) {
		this.interestSidoCode=interestSidoCode;
        this.interestGugunCode=interestGugunCode;
	}
	
	public User(String id, boolean isReview) {
		this.id=id;
        this.isReview=isReview;
	}
	
}

