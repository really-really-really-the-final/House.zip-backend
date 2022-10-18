package com.housezip.model.repo;

import java.sql.SQLException;
import java.util.List;

import com.housezip.dto.Store;

public interface StoreRepo {
	List<Store> storeList(String dongCode) throws SQLException;
}
