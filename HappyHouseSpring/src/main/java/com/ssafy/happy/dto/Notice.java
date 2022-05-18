package com.ssafy.happy.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Notice {
	int no;
	String userId;
	String title;
	String content;
	String regtime;
	public Notice(String userId, String title, String content){
		this.userId=userId;
		this.title=title;
		this.content=content;
	}
	public Notice(int no, String userId, String title, String content){
		this.no=no;
		this.userId=userId;
		this.title=title;
		this.content=content;
	}
}
