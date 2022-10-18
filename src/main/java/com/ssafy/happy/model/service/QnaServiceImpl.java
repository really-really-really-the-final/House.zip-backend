package com.ssafy.happy.model.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.happy.dto.Qna;
import com.ssafy.happy.model.repo.QnaRepo;

@Service
public class QnaServiceImpl implements QnaService {

	@Autowired
	public QnaRepo repo;
	
	@Override
	public Qna select(int no) throws SQLException {
		return repo.select(no);
	}

	@Override
	public List<Qna> selectAll(int limit, int offset) throws SQLException {
		return repo.selectAll(limit, offset);
	}

	@Override
	public int insert(Qna notice) throws SQLException {
		return repo.insert(notice);
	}

	@Override
	public int delete(int no) throws SQLException {
		return repo.delete(no);
	}

	@Override
	public int updateAsk(Qna notice) throws SQLException {
		return repo.updateAsk(notice);
	}

	@Override
	public int updateAns(Qna notice) throws SQLException {
		return repo.updateAns(notice);
	}

	@Override
	public void updateHit(int no) {
		repo.updateHit(no);
	}

	@Override
	public List<Qna> selectAns(int limit, int offset) throws SQLException {
		return repo.selectAns(limit, offset);
	}
	@Override
	public List<Qna> selectMyAns(String userid,int limit, int offset) throws SQLException {
		return repo.selectMyAns(userid,limit, offset);
	}
	@Override
	public List<Qna> selectMyAll(String userid,int limit, int offset) throws SQLException {
		return repo.selectMyAll(userid,limit, offset);
	}

	@Override
	public int selectBoardTotalCount() {
		return repo.selectBoardTotalCount();
	}
	@Override
	public int selectBoardAnsTotalCount() {
		return repo.selectBoardAnsTotalCount();
	}

}
