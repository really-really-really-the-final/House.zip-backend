package com.housezip.model.service;

import java.sql.SQLException;
import java.util.List;

import com.housezip.dto.Review;

public interface ReviewService {
	List<Review> selectAll() throws SQLException;
	List<Review> select(int aptCode) throws SQLException;
	int insert(Review review) throws SQLException;
    int delete(String userid, int aptCode) throws SQLException;
    int update(String userid, int aptCode) throws SQLException;
 
}