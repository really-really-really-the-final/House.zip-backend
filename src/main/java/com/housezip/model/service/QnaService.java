package com.housezip.model.service;

import java.sql.SQLException;
import java.util.List;

import com.housezip.dto.Qna;

public interface QnaService {
	Qna select(int no) throws SQLException;
	List<Qna> selectAns(int limit, int offset) throws SQLException;
	List<Qna> selectAll(int limit, int offset) throws SQLException;
	int insert(Qna notice) throws SQLException;
	int delete(int no) throws SQLException;
    int updateAsk(Qna notice) throws SQLException;
    int updateAns(Qna notice) throws SQLException;
    void updateHit(int no);
 	int selectBoardTotalCount();
    int selectBoardAnsTotalCount();
	List<Qna> selectMyAns(String userid, int limit, int offset) throws SQLException;
	List<Qna> selectMyAll(String userid, int limit, int offset) throws SQLException;
}
