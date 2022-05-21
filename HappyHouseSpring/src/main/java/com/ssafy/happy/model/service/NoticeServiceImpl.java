package com.ssafy.happy.model.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.happy.dto.Notice;
import com.ssafy.happy.model.repo.NoticeRepo;

@Service
public class NoticeServiceImpl implements NoticeService {
	
	@Autowired
	public NoticeRepo repo;

	@Override
	public Notice select(int no) throws SQLException {
		return repo.select(no);
	}

//	@Override
//	public List<Notice> selectAll(String sortCal,String sortVal) throws SQLException {
//		return repo.selectAll(sortCal, sortVal);
//	}

	
	@Override
	@Transactional
	public int insert(Notice notice) throws SQLException {
		return repo.insert(notice);
	}

	@Override
	@Transactional
	public int delete(int no) throws SQLException {
		return repo.delete(no);
	}

	@Override
	@Transactional
	public int update(Notice notice) throws SQLException {
		return repo.update(notice);
	}
	@Override
	public void updateHit(int no) {
		repo.updateHit(no);
	}

	@Override
	public List<Notice> selectBoardLimitOffset(String sortCal,String sortVal,int limit, int offset) {
		return repo.selectBoardLimitOffset(sortCal, sortVal, limit, offset);
	}

	@Override
	public int selectBoardTotalCount() {
		return repo.selectBoardTotalCount();
	}
}
