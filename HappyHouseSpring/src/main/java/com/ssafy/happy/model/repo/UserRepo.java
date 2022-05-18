package com.ssafy.happy.model.repo;

import java.sql.SQLException;

import com.ssafy.happy.dto.User;

public interface UserRepo {

	User select(String id) throws SQLException;
	int insert(User user) throws SQLException;
    int delete(String id) throws SQLException;
    int update(User user) throws SQLException;
}
