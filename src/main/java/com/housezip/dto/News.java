package com.housezip.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class News {
	private String title;
	private String content;
	private String time;
	private String url;
}
