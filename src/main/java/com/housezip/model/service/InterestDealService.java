package com.housezip.model.service;

import java.sql.SQLException;
import java.util.List;

import com.housezip.dto.InterestDeal;

public interface InterestDealService {

	List<InterestDeal> selectAll() throws SQLException;
	List<InterestDeal> select(String userid) throws SQLException;
	int insert(InterestDeal interestDeal) throws SQLException;
    int delete(InterestDeal interestDeal) throws SQLException;
}
