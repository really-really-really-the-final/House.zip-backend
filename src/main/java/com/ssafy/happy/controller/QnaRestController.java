package com.ssafy.happy.controller;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ssafy.happy.dto.Notice;
import com.ssafy.happy.dto.Qna;
import com.ssafy.happy.model.service.QnaService;

import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins = { "*" }, maxAge = 6000)
@RestController
@RequestMapping("/qna")
public class QnaRestController {

	private static final Logger logger = LoggerFactory.getLogger(QnaRestController.class);
	private static final String SUCCESS = "success";
	private static final String FAIL = "fail";

	@Autowired
	QnaService qsvc;

	@ApiOperation(value = "모든 QnA의 정보를 반환한다.", response = List.class)
	@GetMapping("/")
	public ResponseEntity<List<Qna>> selectAll(int limit, int offset) throws SQLException {
		logger.debug("selectAll - 호출");
		return new ResponseEntity<>(qsvc.selectAll(limit, offset), HttpStatus.OK);
	}
	
	@ApiOperation(value = "답변이 달린 모든 QnA의 정보를 반환한다.", response = List.class)
	@GetMapping("/ans")
	public ResponseEntity<List<Qna>> selectAns( int limit, int offset) throws SQLException {
		logger.debug("selectMyAns - 호출");
		return new ResponseEntity<>(qsvc.selectAns(limit, offset), HttpStatus.OK);
	}

	
	@ApiOperation(value = "모든 QnA의 정보를 반환한다.", response = List.class)
	@GetMapping("/my")
	public ResponseEntity<List<Qna>> selectMyAll(String userid, int limit, int offset) throws SQLException {
		logger.debug("selectMyAll - 호출");
		return new ResponseEntity<>(qsvc.selectMyAll(userid,limit, offset), HttpStatus.OK);
	}
	
	@ApiOperation(value = "답변이 달린 모든 QnA의 정보를 반환한다.", response = List.class)
	@GetMapping("/my/ans")
	public ResponseEntity<List<Qna>> selectMyAns(String userid,int limit, int offset) throws SQLException {
		logger.debug("selectAns - 호출");
		return new ResponseEntity<>(qsvc.selectMyAns(userid,limit, offset), HttpStatus.OK);
	}


	@ApiOperation(value = "게시글의 전체 건수를 반환한다.  ", response = List.class)
	@GetMapping(value = "/total")
	public ResponseEntity<Integer> selectBoardTotalCount() throws Exception {
		logger.debug("selectBoardTotalCount - 호출");
		return new ResponseEntity<Integer>(qsvc.selectBoardTotalCount(), HttpStatus.OK);
	}
	
	@ApiOperation(value = "답변이 달린 모든 QnA 건수를 반환한다.  ", response = List.class)
	@GetMapping(value = "/ans/total")
	public ResponseEntity<Integer> selectBoardTotalAnsCount() throws Exception {
		logger.debug("selectBoardTotalAnsCount - 호출");
		return new ResponseEntity<Integer>(qsvc.selectBoardAnsTotalCount(), HttpStatus.OK);
	}

	@ApiOperation(value = "{no}에 해당하는 QnA 정보를 반환한다.", response = Qna.class)
	@GetMapping("/{no}")
	public ResponseEntity<Qna> select(@PathVariable int no) throws SQLException {
	  	logger.debug("updateHit - 호출");
	  	qsvc.updateHit(no);
		logger.debug("select - 호출");
		return new ResponseEntity<>(qsvc.select(no), HttpStatus.OK);
	}

	@ApiOperation(value = "{no}에 해당하는 QnA를 삭제한다. 그리고 DB삭제 성공여부에 따라 'success' 또는 'fail' 문자열을 반환한다.", response = String.class)
	@DeleteMapping("/{no}")
	public ResponseEntity<String> delete(@PathVariable int no) throws SQLException {
		logger.debug("delete - 호출");
		if (qsvc.delete(no) == 1) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		}
		return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
	}

	@ApiOperation(value = "새로운 QnA를 등록한다. 그리고 DB입력 성공여부에 따라 'success' 또는 'fail' 문자열을 반환한다.", response = String.class)
	@PostMapping("/")
	public ResponseEntity<String> insert(@RequestBody Qna qna) throws SQLException {
		logger.debug("insert - 호출");
		if (qsvc.insert(qna) == 1) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		}
		return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
	}

	@ApiOperation(value = "{no}에 해당하는 QnA를 수정한다. 그리고 DB수정 성공여부에 따라 'success' 또는 'fail' 문자열을 반환한다.", response = String.class)
	@PutMapping("/{no}")
	public ResponseEntity<String> updateAsk(@RequestBody Qna qna) throws SQLException {
		logger.debug("updateAsk - 호출");
		logger.debug("" + qna);
		if (qsvc.updateAsk(qna) == 1) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		}
		return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
	}

	@ApiOperation(value = "{no}에 해당하는 QnA의 답변을 수정한다. 그리고 DB수정 성공여부에 따라 'success' 또는 'fail' 문자열을 반환한다.", response = String.class)
	@PutMapping("/ans/{no}")
	public ResponseEntity<String> updateAns(@RequestBody Qna qna) throws SQLException {
		logger.debug("updateAns - 호출");
		logger.debug("" + qna);
		if (qsvc.updateAns(qna) == 1) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		}
		return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
	}

}