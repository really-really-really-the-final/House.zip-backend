package com.ssafy.happy.model.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.happy.dto.InterestDeal;
import com.ssafy.happy.model.repo.InterestDealRepo;

@Service
public class InterestDealServiceImpl implements InterestDealService {
	@Autowired
	public InterestDealRepo repo;
	
	@Override
	public List<InterestDeal> selectAll() throws SQLException {
		return repo.selectAll();
	}
	
	@Override
	public List<InterestDeal>  select(String id) throws SQLException {
		return repo.select(id);
	}

	@Override
	@Transactional
	public int insert(InterestDeal interestDeal) throws SQLException {
		return repo.insert(interestDeal);
	}

	@Override
	@Transactional
	public int delete(InterestDeal interestDeal) throws SQLException {
		return repo.delete(interestDeal);
	}

	
}
