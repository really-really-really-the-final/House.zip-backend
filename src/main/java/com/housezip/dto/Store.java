package com.housezip.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Store{
	private int no;
	private String name;
	private String category;
	private String address;
	private String lat;
	private String lng;
}