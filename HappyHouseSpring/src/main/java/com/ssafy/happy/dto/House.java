package com.ssafy.happy.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class House {
	
	private int no;
	private int aptCode;
	private String aptName;
	private String dongCode;
	private String dongName;
	private int buildYear;
	private String jibun;
	private String lat;
	private String lng;
	private String img;
	private String dealAmount;
	private String dealYear;
	private String dealMonth;
	private String dealDay;
	private String area;
	private String floor;
	private String type;
	private String rentMoney;
	private String infoType;
	private String dealType;
	private int total;
	private int dist;
	
	public House(int no, int aptCode, String aptName, String dongCode, String dongName, int buildYear, String jibun,
			String lat, String lng, String img, String dealAmount, String dealYear, String dealMonth, String dealDay,
			String area, String floor, String type, String rentMoney,String infoType, String dealType, int total) {
		super();
		this.no = no;
		this.aptCode = aptCode;
		this.aptName = aptName;
		this.dongCode = dongCode;
		this.dongName = dongName;
		this.buildYear = buildYear;
		this.jibun = jibun;
		this.lat = lat;
		this.lng = lng;
		this.img = img;
		this.dealAmount = dealAmount;
		this.dealYear = dealYear;
		this.dealMonth = dealMonth;
		this.dealDay = dealDay;
		this.area = area;
		this.floor = floor;
		this.type = type;
		this.rentMoney = rentMoney;
		this.infoType = infoType;
		this.dealType = dealType;
		this.total = total;
	}
	
}
