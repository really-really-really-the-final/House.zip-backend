package com.housezip.model.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.housezip.dto.Review;
import com.housezip.model.repo.ReviewRepo;

@Service
public class ReviewServiceImpl implements ReviewService {
	@Autowired
	public ReviewRepo repo;
	
	@Override
	public List<Review> selectAll() throws SQLException {
		return repo.selectAll();
	}
	
	@Override
	public List<Review> select(int aptCode) throws SQLException {
		return repo.select(aptCode);
	}

	@Override
	@Transactional
	public int insert(Review review) throws SQLException {
		return repo.insert(review);
	}

	@Override
	@Transactional
	public int delete(String userid, int aptCode) throws SQLException {
		return repo.delete(userid,aptCode);
	}

	@Override
	@Transactional
	public int update(String userid, int aptCode) throws SQLException {
		return repo.update(userid,aptCode);
	}

}
