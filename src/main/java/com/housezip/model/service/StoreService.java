package com.housezip.model.service;

import java.sql.SQLException;
import java.util.List;

import com.housezip.dto.Store;

public interface StoreService {
	List<Store> storeList(String dongCode) throws SQLException;
}
