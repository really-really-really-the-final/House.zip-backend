package com.ssafy.happy.model.repo;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.happy.dto.Notice;

public interface NoticeRepo {

	Notice select(int no) throws SQLException;

//	List<Notice> selectAll(String sortCal,String sortVal) throws SQLException;
	int insert(Notice notice) throws SQLException;

	int delete(int no) throws SQLException;

	int update(Notice notice) throws SQLException;

	void updateHit(int no);

	// for pagination (page-link)
	List<Notice> selectBoardLimitOffset(String sortCal, String sortVal, int limit, int offset);

	int selectBoardTotalCount();
}
