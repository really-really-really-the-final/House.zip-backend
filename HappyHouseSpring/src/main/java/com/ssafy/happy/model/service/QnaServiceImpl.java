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
	public List<Qna> selectAll() throws SQLException {
		return repo.selectAll();
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

}
