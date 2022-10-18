package com.housezip.model.repo;

import java.sql.SQLException;
import java.util.List;

import com.housezip.dto.User;

public interface UserRepo {

	List<User> selectAll() throws SQLException;
	User select(String id) throws SQLException;
	int insert(User user) throws SQLException;
    int delete(String id) throws SQLException;
    int update(User user) throws SQLException;
    int updateIsReview(String id) throws SQLException;
    String selectCate(String id) throws SQLException;
    User selectInte(String id) throws SQLException;
}
