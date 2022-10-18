package com.housezip.model.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.housezip.dto.User;
import com.housezip.model.repo.UserRepo;

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

	@Override
	public String selectCate(String id) throws SQLException {
		return repo.selectCate(id);
	}
	
	@Override
	public User login(String id, String password) throws SQLException {
		User selected = repo.select(id);
		if (id.equals(selected.getId()) && password.equals(selected.getPassword())) {
			return selected;
		} else {
			throw new RuntimeException("로그인 실패");
		}
	}

	@Override
	public User selectInte(String id) throws SQLException {
		return repo.selectInte(id);
	}

	@Override
	public int updateIsReview(String id) throws SQLException {
		return repo.updateIsReview(id);
	}
}
