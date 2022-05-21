package com.ssafy.happy.controller;

import java.sql.SQLException;
import java.util.List;

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

import com.ssafy.happy.dto.Notice;
import com.ssafy.happy.model.service.NoticeService;

import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins = { "*" }, maxAge = 6000)
@RestController
@RequestMapping("/notice")
public class NoticeRestController {
	
	private static final Logger logger = LoggerFactory.getLogger(NoticeRestController.class);
	private static final String SUCCESS = "success";
	private static final String FAIL = "fail";
	
	@Autowired
	NoticeService nsvc;
	
	@ApiOperation(value = "limit offset 에 해당하는 게시글의 정보를 반환한다.  ", response = List.class)
	@GetMapping(value = "/")
	public ResponseEntity<List<Notice>> selectBoardLimitOffset(@RequestParam String sortCal,@RequestParam String sortVal,int limit, int offset) throws Exception {
//		logger.debug("selectBoardLimitOffset - 호출");
		System.out.println("limit : " + limit + " / offset : " + offset);
		return new ResponseEntity<List<Notice>>(nsvc.selectBoardLimitOffset(sortCal, sortVal,limit, offset), HttpStatus.OK);
	}

	@ApiOperation(value = "게시글의 전체 건수를 반환한다.  ", response = List.class)
	@GetMapping(value = "/total")
	public ResponseEntity<Integer> selectBoardTotalCount() throws Exception {
//		logger.debug("selectBoardTotalCount - 호출");
		return new ResponseEntity<Integer>(nsvc.selectBoardTotalCount(), HttpStatus.OK);
	}

//	@ApiOperation(value = "모든 공지사항의 정보를 반환한다.", response = List.class)
//	@GetMapping("/")
//	public ResponseEntity<List<Notice>> selectAll(@RequestParam String sortCal,@RequestParam String sortVal) throws SQLException {
////		logger.debug("selectAll - 호출");
//		return new ResponseEntity<>(nsvc.selectAll(sortCal, sortVal), HttpStatus.OK);
//	}

	@ApiOperation(value = "{no}에 해당하는 공지사항의 정보를 반환한다.", response = Notice.class)
	@GetMapping("/{no}")
	public ResponseEntity<Notice> select(@PathVariable int no) throws SQLException {
		logger.debug("updateHit - 호출");
		nsvc.updateHit(no);
		logger.debug("select - 호출");
		return new ResponseEntity<>(nsvc.select(no), HttpStatus.OK);
	}
	
	@ApiOperation(value = "{no}에 해당하는 공지사항을 삭제한다. 그리고 DB삭제 성공여부에 따라 'success' 또는 'fail' 문자열을 반환한다.", response = String.class)
	@DeleteMapping("/{no}")
	public ResponseEntity<String> delete(@PathVariable int no) throws SQLException {
		logger.debug("delete - 호출");
		if(nsvc.delete(no)==1) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		}
		return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
	}
	
	@ApiOperation(value = "새로운 공지사항을 등록한다. 그리고 DB입력 성공여부에 따라 'success' 또는 'fail' 문자열을 반환한다.", response = String.class)
	@PostMapping("/")
	public ResponseEntity<String> insert(@RequestBody Notice notice) throws SQLException {
		logger.debug("insert - 호출");
		if(nsvc.insert(notice)==1) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		}
		return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
	}

	@ApiOperation(value = "{no}에 해당하는 공지사항을 수정한다. 그리고 DB수정 성공여부에 따라 'success' 또는 'fail' 문자열을 반환한다.", response = String.class)
	@PutMapping("/{no}")
	public ResponseEntity<String> update(@PathVariable int no, @RequestBody Notice notice) throws SQLException {
		
		logger.debug("update - 호출");
		logger.debug("" + notice);
		if(nsvc.update(notice)==1) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		}
		return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
	}

}