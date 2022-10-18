package com.housezip.model.service;

import java.util.List;

import com.housezip.dto.Dong;
import com.housezip.dto.Gugun;
import com.housezip.dto.Sido;

public interface AreaService {

	List<Sido> selectSido();
	List<Gugun> selectGugun(String sido);
	List<Dong>selectDong(String gugun);
}
