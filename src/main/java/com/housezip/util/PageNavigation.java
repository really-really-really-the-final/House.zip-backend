package com.housezip.util;

public class PageNavigation {
	private int startPage;
	private int endPage;
	private boolean startRange;
	private boolean endRange;
	private int totalCount;
	private int totalPageCount;
	private int currentPage;
	private int countPerPage;
	int itemPerPage = 10;
	int maxDisplayNavCnt = 10;

	public PageNavigation(int currentPage, int totalCount) {
		makePageNavigation(currentPage, totalCount);
	}

	public boolean isStartRange() {
		return startRange;
	}
	public void setStartRange(boolean startRange) {
		this.startRange = startRange;
	}
	public boolean isEndRange() {
		return endRange;
	}
	public void setEndRange(boolean endRange) {
		this.endRange = endRange;
	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	public int getTotalPageCount() {
		return totalPageCount;
	}
	public void setTotalPageCount(int totalPageCount) {
		this.totalPageCount = totalPageCount;
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
	public void setCountPerPage(int countPerPage) {
		this.countPerPage = countPerPage;
	}
	public int getStartPage() {
		return startPage;
	}
	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}
	public int getEndPage() {
		return endPage;
	}
	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}

	private void makePageNavigation(int currentPage, int totalCount) {
		this.setCurrentPage(currentPage);
		this.setTotalCount(totalCount);
		this.setCountPerPage(itemPerPage);

		int totalPageCount = (totalCount - 1) / itemPerPage + 1;
		this.setTotalPageCount(totalPageCount);

		this.setStartPage((currentPage - 1) / maxDisplayNavCnt * maxDisplayNavCnt + 1); //수정

		this.setEndPage(this.getStartPage() + maxDisplayNavCnt - 1);
		if (totalPageCount < this.getEndPage()) {
			this.setEndPage(totalPageCount);
		}
		this.setStartRange(currentPage <= maxDisplayNavCnt); //수정
		boolean endRange = (totalPageCount - 1) / maxDisplayNavCnt * maxDisplayNavCnt < currentPage; //수정
		this.setEndRange(endRange);
	}
}
