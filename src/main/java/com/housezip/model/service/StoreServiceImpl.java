package com.housezip.model.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.housezip.dto.Store;
import com.housezip.model.repo.StoreRepo;

@Service
public class StoreServiceImpl implements StoreService{
	@Autowired
	public StoreRepo repo;
	
	@Override
	public List<Store> storeList(String dongCode) throws SQLException {
		return repo.storeList(dongCode);
	}

}