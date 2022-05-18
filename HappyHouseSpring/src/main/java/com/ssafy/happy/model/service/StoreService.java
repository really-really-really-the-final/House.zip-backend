package com.ssafy.happy.model.service;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.happy.dto.Store;

public interface StoreService {
	List<Store> storeList(String dongCode) throws SQLException;
}
