package com.housezip.model.repo;

import java.util.List;

import com.housezip.dto.Avgamount;
import com.housezip.dto.House;

public interface HouseRepo {

	House select(int no);
	List<House> selectGugun(String gugun);
	List<House> selectDong(String dong);
	List<House> selectApt(String aptCode);
	List<House> selectDist(String lat, String lng, String dist);
	List<House> selectAptCode(String userid, String aptCode);
	List<House> selectInte(List<String> aptCode);
	List<Avgamount> getAvgAll();
	List<Avgamount> getAvgSido(String dongCode);
	List<Avgamount> getAvgGugun(String dongCode);
	List<Avgamount> getAvgDong(String dongCode);
}
