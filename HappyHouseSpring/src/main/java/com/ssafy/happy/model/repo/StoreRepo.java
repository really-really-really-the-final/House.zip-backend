package com.ssafy.happy.model.repo;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.happy.dto.Store;

public interface StoreRepo {
	List<Store> storeList(String dongCode) throws SQLException;
}
