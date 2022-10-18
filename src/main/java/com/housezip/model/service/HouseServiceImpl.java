package com.housezip.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.housezip.dto.Avgamount;
import com.housezip.dto.House;
import com.housezip.model.repo.HouseRepo;
import com.housezip.model.repo.InterestDealRepo;
import com.housezip.util.PageNavigation;

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
	public List<House> selectAptCode(String userid, String aptCode){
		return repo.selectAptCode(userid, aptCode);
	}
	
	@Override
	public House select(int no){
		return repo.select(no);
	}
	@Override
	public List<House> selectDong(String dong) {
		return repo.selectDong(dong);
	}
	@Override
	public List<House> selectApt(String aptCode) {
		return repo.selectApt(aptCode);
	}

	@Override
	public List<House> selectGugun(String gugun) {
		return repo.selectGugun(gugun);
	}
	@Override
	public List<House> selectDist(String lat, String lng, String dist) {
		return repo.selectDist(lat, lng, dist);
	}

	@Override
	public List<House> selectInte(List<String> aptCode) {
		return repo.selectInte(aptCode);
	}

	@Override
	public List<Avgamount> getAvgAll() {
		return repo.getAvgAll();
	}

	@Override
	public List<Avgamount> getAvgSido(String dongCode) {
		return repo.getAvgSido(dongCode);
	}

	@Override
	public List<Avgamount> getAvgGugun(String dongCode) {
		return repo.getAvgGugun(dongCode);
	}

	@Override
	public List<Avgamount> getAvgDong(String dongCode) {
		return repo.getAvgDong(dongCode);
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
