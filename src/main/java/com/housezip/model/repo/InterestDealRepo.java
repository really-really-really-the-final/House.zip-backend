package com.housezip.model.repo;

import java.sql.SQLException;
import java.util.List;

import com.housezip.dto.InterestDeal;

public interface InterestDealRepo {

	List<InterestDeal> selectAll() throws SQLException;
	List<InterestDeal> select(String userid) throws SQLException;
	int insert(InterestDeal interestDeal) throws SQLException;
    int delete(InterestDeal interestDeal) throws SQLException;
}
