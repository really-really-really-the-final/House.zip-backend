package com.ssafy.happy.controller;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.happy.dto.House;
import com.ssafy.happy.dto.SearchCondition;
import com.ssafy.happy.model.service.HouseService;

import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins = { "*" }, maxAge = 6000)
@RestController
@RequestMapping("/house")
public class HouseRestController {

	private static final Logger logger = LoggerFactory.getLogger(HouseRestController.class);
	private static final String SUCCESS = "success";
	private static final String FAIL = "fail";
	
	@Autowired
	HouseService hsvc;
	
	@ApiOperation(value = "전체 아파트 정보 중 일부 정보를 반환한다.", response = List.class)
	@PostMapping("/all")
	public ResponseEntity<?> all(@RequestBody SearchCondition condition, Model m) throws SQLException {
		logger.debug("all - 호출");
		Map<String, Object> map = hsvc.pagingSearch(condition);
		return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
	}
	
	@ApiOperation(value = "해당 동에 있는 아파트 정보를 반환한다.", response = List.class)
	@PostMapping("/dong")
	public ResponseEntity<List<House>> dongList(@RequestBody String dong) throws SQLException {
		logger.debug("dongList - 호출");
		return new ResponseEntity<>(hsvc.selectDong(dong), HttpStatus.OK);
	}
	
	@ApiOperation(value = "아파트 명에 해당 단어가 들어있는 아파트 정보를 반환한다.", response = List.class)
	@PostMapping("/apt")
	public ResponseEntity<List<House>> aptList(@RequestBody String aptName) throws SQLException {
		logger.debug("aptList - 호출");
		return new ResponseEntity<>(hsvc.selectApt(aptName), HttpStatus.OK);
	}
	
	@ApiOperation(value = "no 번호를 가지는 아파트 정보를 반환한다.", response = House.class)
	@GetMapping("/view")
	public ResponseEntity<House> view(@RequestParam int no) throws SQLException {
		logger.debug("view - 호출");
		return new ResponseEntity<>(hsvc.select(no), HttpStatus.OK);
	}

}