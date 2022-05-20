package com.ssafy.happy.model.repo;

import java.util.List;

import com.ssafy.happy.dto.House;
import com.ssafy.happy.dto.SearchCondition;

public interface HouseRepo {

	House select(int no);
	List<House> selectGugun(String gugun);
	List<House> selectDong(String dong);
	List<House> selectApt(String aptCode);
}
