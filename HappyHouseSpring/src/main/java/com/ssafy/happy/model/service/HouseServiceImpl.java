package com.ssafy.happy.model.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.happy.dto.House;
import com.ssafy.happy.dto.SearchCondition;
import com.ssafy.happy.model.repo.HouseRepo;
import com.ssafy.happy.util.PageNavigation;

@Service
public class HouseServiceImpl implements HouseService {
	
	@Autowired
	public HouseRepo repo;
	
//	@Override
//	public List<House> selectGugun(String guGun) throws SQLException {
//		System.out.println("guGun "+ guGun);
//		return repo.selectGugun(guGun);
//	}
	
	@Override
	public House select(int no){
		return repo.select(no);
	}
	@Override
	public List<House> selectDong(String dong) {
		return repo.selectDong(dong);
	}
	@Override
	public List<House> selectApt(String aptName) {
		return repo.selectApt(aptName);
	}

	@Override
	public List<House> selectGugun(String gugun) {
		return repo.selectGugun(gugun);
	}
	
//	@Override
//	public List<House> selectGugun(SearchCondition condition) {
//		return selectGugun(condition);
//	}
	
//	@Override
//	public List<House> selectDong(SearchCondition condition) {
//		return selectDong(condition);
//	}
//
//	@Override
//	public List<House> selectApt(SearchCondition condition) {
//		return selectApt(condition);
//	}
//
//	@Override
//	public Map<String, Object> pagingSearch(SearchCondition condition) {
//		int totalCount=repo.getTotalSearchCount(condition);
//		PageNavigation nav=new PageNavigation(condition.getCurrentPage(), totalCount);
////		String gugun=condition.getGugun();
//		Map<String, Object> map=new HashMap<String, Object>();
//		map.put("houses", repo.selectGugun(condition));
//		map.put("navigation", nav);
//		return map;
//	}

}
