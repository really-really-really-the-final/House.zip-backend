package com.ssafy.happy.model.service;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.happy.dto.InterestDeal;
import com.ssafy.happy.dto.User;

public interface InterestDealService {

	List<InterestDeal> selectAll() throws SQLException;
	List<InterestDeal> select(String userid) throws SQLException;
	int insert(InterestDeal interestDeal) throws SQLException;
    int delete(InterestDeal interestDeal) throws SQLException;
}
