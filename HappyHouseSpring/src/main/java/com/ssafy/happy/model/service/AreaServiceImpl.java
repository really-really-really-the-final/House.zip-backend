package com.ssafy.happy.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.happy.dto.Dong;
import com.ssafy.happy.dto.Gugun;
import com.ssafy.happy.dto.Sido;
import com.ssafy.happy.model.repo.AreaRepo;

@Service
public class AreaServiceImpl implements AreaService {

	@Autowired
	public AreaRepo repo;
	@Override
	public List<Sido> selectSido() {
		return repo.selectSido();
	}

	@Override
	public List<Gugun> selectGugun(String sido) {
		return repo.selectGugun(sido);
	}

	@Override
	public List<Dong> selectDong(String gugun) {
		return repo.selectDong(gugun);
	}

}
