package com.ssafy.happy.model.service;

import java.util.List;
import java.util.Map;

import com.ssafy.happy.dto.House;
import com.ssafy.happy.dto.SearchCondition;

public interface HouseService {
	
	House select(int no);
	List<House> selectGugun(SearchCondition condition);
	List<House> selectDong(String dong);
	List<House> selectApt(String aptName);
	Map<String, Object> pagingSearch(SearchCondition condition);
}
