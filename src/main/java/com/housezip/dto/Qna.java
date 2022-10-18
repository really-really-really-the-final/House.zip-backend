package com.housezip.dto;

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
	String userid;
	String title;
	String content;
	String asktime;
	String masterid;
	String anscontent;
	String anstime;
	int hit;
	
	public Qna(String userid, String title, String content){
		this.userid=userid;
		this.title=title;
		this.content=content;
	}
	public Qna(int no, String userid, String title, String content){
		this.no=no;
		this.userid=userid;
		this.title=title;
		this.content=content;
	}
	public Qna(String userid, String title, String content, String asktime,
			String masterid, String anscontent){
		this.userid=userid;
		this.title=title;
		this.content=content;
		this.asktime=asktime;
		this.masterid=masterid;
		this.anscontent=anscontent;
	}
	public Qna(int no, String userid, String title, String content, String asktime,
			String masterid, String anscontent){
		this.no=no;
		this.userid=userid;
		this.title=title;
		this.content=content;
		this.asktime=asktime;
		this.masterid=masterid;
		this.anscontent=anscontent;
	}
}
