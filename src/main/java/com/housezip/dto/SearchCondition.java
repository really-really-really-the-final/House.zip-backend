package com.housezip.dto;

public class SearchCondition {
	public final int countPerPage = 10;

	private String sido = "none";
	private String gugun = "none";
	private int currentPage = 1;
	private boolean limit = true;

	public SearchCondition() {
	}

	public SearchCondition(String sido, String gugun) {
		this(sido, gugun,1);
	}

	public SearchCondition(String sido, String gugun, int currentPage) {
		this.sido = sido;
		this.gugun = gugun;
		this.currentPage = currentPage;
	}
	public String getSido() {
		return sido;
	}
	public void setSido(String sido) {
		this.sido = sido;
	}
	public String getGugun() {
		return gugun;
	}
	public void setGugun(String gugun) {
		this.gugun = gugun;
	}
	
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getCountPerPage() {
		return countPerPage;
	}
	public boolean isLimit() {
		return limit;
	}
	public void setLimit(boolean limit) {
		this.limit = limit;
	}
	public int getOffset() {
		return (this.currentPage - 1) * countPerPage;
	}

}
