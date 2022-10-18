package com.ssafy.happy.model.repo;

import java.util.List;

import com.ssafy.happy.dto.Dong;
import com.ssafy.happy.dto.Gugun;
import com.ssafy.happy.dto.Sido;

public interface AreaRepo {

	List<Sido> selectSido();
	List<Gugun> selectGugun(String sido);
	List<Dong>selectDong(String gugun);
}
