package com.housezip.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.housezip.dto.Dong;
import com.housezip.dto.Gugun;
import com.housezip.dto.Sido;
import com.housezip.model.repo.AreaRepo;

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
