package com.housezip.model.service;

import java.sql.SQLException;
import java.util.List;

import com.housezip.dto.Notice;

public interface NoticeService {

	Notice select(int no) throws SQLException;

	int insert(Notice notice) throws SQLException;

	int delete(int no) throws SQLException;

	int update(Notice notice) throws SQLException;

	void updateHit(int no);

	List<Notice> selectBoardLimitOffset(String sortCal, String sortVal, int limit, int offset);

	int selectBoardTotalCount();
}
