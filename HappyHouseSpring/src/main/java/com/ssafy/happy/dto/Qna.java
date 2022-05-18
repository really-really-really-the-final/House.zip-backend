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
public class Qna {
	int no;
	String userId;
	String title;
	String content;
	String asktime;
	String masterid;
	String anscontent;
	String anstime;
	
	public Qna(String userId, String title, String content){
		this.userId=userId;
		this.title=title;
		this.content=content;
	}
	public Qna(int no, String userId, String title, String content){
		this.no=no;
		this.userId=userId;
		this.title=title;
		this.content=content;
	}
	public Qna(String userId, String title, String content, String asktime,
			String masterid, String anscontent){
		this.userId=userId;
		this.title=title;
		this.content=content;
		this.asktime=asktime;
		this.masterid=masterid;
		this.anscontent=anscontent;
	}
	public Qna(int no, String userId, String title, String content, String asktime,
			String masterid, String anscontent){
		this.no=no;
		this.userId=userId;
		this.title=title;
		this.content=content;
		this.asktime=asktime;
		this.masterid=masterid;
		this.anscontent=anscontent;
	}
}
