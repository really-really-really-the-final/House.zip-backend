package com.ssafy.happy.dto;

public class SearchCondition {
	// 한 페이지에 몇개나 보여줄 것인지 결정한다.
	public final int countPerPage = 10; //2; //PageNavigation의 itemPerPage와 같아야 함

	// 검색 컬럼으로 기본인 none은 검색하지 않는다. ex) isbn
//	private String key = "none";
	// 검색어: ex: 111-222-3333
//	private String word;
	// 검색 결과를 정렬할 컬럼 이름으로 기본인 none은 정렬하지 않는다., ex)author
//	private String orderBy = "none";
	// 정렬 방향으로 기본은 asc
//	private String orderByDir = "asc";
	
	private String sido = "none";
	private String gugun = "none";
	// 현재 페이지 번호로 offset을 계산할 때 사용된다. 기본 페이지는 1이다.
	private int currentPage = 1;
	// limit 를 적용할 것인지 설정한다.
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
	/**
	 * limit의 offset을 구한다.
	 * 페이징으로 일부분만을 가져올 때 페이지의 시작 정보 위치로 메서드에 의해 계산된다.
	 * 전달된 currentPage는 1부터 시작하고 DB는 0부터이므로 1을 빼준다.
	 * @return
	 */
	public int getOffset() {
		return (this.currentPage - 1) * countPerPage;
	}

//	@Override
//	public String toString() {
//		return "SearchCondition [key=" + key + ", word=" + word + ", orderBy=" + orderBy + ", orderByDir=" + orderByDir + ", currentPage=" + currentPage + "]";
//	}
}
