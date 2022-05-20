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
	String userid;
	String title;
	String content;
	String regtime;
	int hit;
	public Notice(String userid, String title, String content){
		this.userid=userid;
		this.title=title;
		this.content=content;
	}
	public Notice(int no, String userid, String title, String content){
		this.no=no;
		this.userid=userid;
		this.title=title;
		this.content=content;
	}
}
