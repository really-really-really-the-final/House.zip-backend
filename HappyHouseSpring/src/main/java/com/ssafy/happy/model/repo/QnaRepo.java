package com.ssafy.happy.model.repo;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.happy.dto.Notice;
import com.ssafy.happy.dto.Qna;

public interface QnaRepo {

	Qna select(int no) throws SQLException;
	List<Qna> selectAns(int limit, int offset) throws SQLException;
	List<Qna> selectAll(int limit, int offset) throws SQLException;
	List<Qna> selectMyAns(String userid, int limit, int offset) throws SQLException;
	List<Qna> selectMyAll(String userid, int limit, int offset) throws SQLException;
	int insert(Qna notice) throws SQLException;
	int delete(int no) throws SQLException;
    int updateAsk(Qna notice) throws SQLException;
    int updateAns(Qna notice) throws SQLException;
    void updateHit(int no);
    
 // for pagination (page-link)
    int selectBoardTotalCount();
    int selectBoardAnsTotalCount();
}
