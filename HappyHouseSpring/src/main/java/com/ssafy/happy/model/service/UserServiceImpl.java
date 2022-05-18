package com.ssafy.happy.model.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.happy.dto.User;
import com.ssafy.happy.model.repo.UserRepo;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	public UserRepo repo;
	
	@Override
	public List<User> selectAll() throws SQLException {
		return repo.selectAll();
	}
	
	@Override
	public User select(String id) throws SQLException {
		return repo.select(id);
	}

	@Override
	@Transactional
	public int insert(User user) throws SQLException {
		return repo.insert(user);
	}

	@Override
	@Transactional
	public int delete(String id) throws SQLException {
		return repo.delete(id);
	}

	@Override
	@Transactional
	public int update(User user) throws SQLException {
		return repo.update(user);
	}
}
