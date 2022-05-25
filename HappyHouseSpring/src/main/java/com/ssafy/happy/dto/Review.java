package com.ssafy.happy.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Review{
	String userid;
	int aptCode;
	int time;
	int commute;
	int park;
	int noise;
	int facilities;
	String content;
}

