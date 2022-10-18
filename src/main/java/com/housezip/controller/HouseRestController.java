package com.housezip.controller;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import org.springframework.web.bind.annotation.RestController;

import com.housezip.dto.Avgamount;
import com.housezip.dto.Dong;
import com.housezip.dto.Gugun;
import com.housezip.dto.House;
import com.housezip.dto.Review;
import com.housezip.dto.Sido;
import com.housezip.model.service.AreaService;
import com.housezip.model.service.HouseService;
import com.housezip.model.service.ReviewService;
import com.housezip.model.service.UserService;

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
	@Autowired
	AreaService asvc;
	@Autowired
	ReviewService rsvc;
	@Autowired
	UserService usvc;

	@ApiOperation(value = "전체 아파트 정보 중 일부 정보를 반환한다.", response = List.class)
	@PostMapping("/all")
	public ResponseEntity<?> all(@RequestBody Map<String, String> param) throws SQLException {
		logger.debug("all - 호출 ");
		return new ResponseEntity<>(hsvc.selectGugun(param.get("gugun")), HttpStatus.OK);
	}

	@ApiOperation(value = "해당 동에 있는 아파트 정보를 반환한다.", response = List.class)
	@PostMapping("/dong")
	public ResponseEntity<List<House>> dongList(@RequestBody Map<String, String> param) throws SQLException {
		logger.debug("dongList - 호출");

		return new ResponseEntity<>(hsvc.selectDong(param.get("dong")), HttpStatus.OK);
	}

	@ApiOperation(value = "해당 반경에 있는 아파트 정보를 반환한다.", response = List.class)
	@PostMapping("/dist")
	public ResponseEntity<List<House>> selectDist(@RequestBody Map<String, String> param) throws SQLException {
		logger.debug("selectDist - 호출");
		return new ResponseEntity<>(hsvc.selectDist(param.get("lat"), param.get("lng"), param.get("dist")),
				HttpStatus.OK);
	}

	@ApiOperation(value = "아파트 코드와 일치하는 아파트 정보를 반환한다.", response = List.class)
	@PostMapping("/apt")
	public ResponseEntity<List<House>> aptList(@RequestBody Map<String, String> param) throws SQLException {
		logger.debug("aptList - 호출");
		return new ResponseEntity<>(hsvc.selectApt(param.get("aptCode")), HttpStatus.OK);
	}

	@ApiOperation(value = "no 번호를 가지는 아파트 정보를 반환한다.", response = House.class)
	@GetMapping("/view")
	public ResponseEntity<House> view(@PathVariable int no) throws SQLException {
		logger.debug("view - 호출");
		return new ResponseEntity<>(hsvc.select(no), HttpStatus.OK);
	}

	@ApiOperation(value = "sido 리스트를 반환한다.", response = List.class)
	@GetMapping("/list/sido")
	public ResponseEntity<List<Sido>> searchSido() throws SQLException {
		logger.debug("searchSido - 호출");
		return new ResponseEntity<>(asvc.selectSido(), HttpStatus.OK);
	}

	@ApiOperation(value = "gugun 리스트를 반환한다.", response = List.class)
	@GetMapping("/list/gugun/{sido}")
	public ResponseEntity<List<Gugun>> searchGugun(@PathVariable String sido) throws SQLException {
		logger.debug("searchGugun - 호출");
		return new ResponseEntity<>(asvc.selectGugun(sido), HttpStatus.OK);
	}

	@ApiOperation(value = "dong 리스트를 반환한다.", response = List.class)
	@GetMapping("/list/dong/{gugun}")
	public ResponseEntity<List<Dong>> searchDong(@PathVariable String gugun) throws SQLException {
		logger.debug("searchDong - 호출");
		return new ResponseEntity<>(asvc.selectDong(gugun), HttpStatus.OK);
	}

	@ApiOperation(value = "사용자 관심매물 리스트를 반환한다.", response = List.class)
	@PostMapping("/interest")
	public ResponseEntity<List<House>> selectInterestDeal(@RequestBody Map<String, List<String>> param) throws SQLException {
		logger.debug("selectInterestDeal - 호출");
		return new ResponseEntity<>(hsvc.selectInte(param.get("aptCode")), HttpStatus.OK);
	}
	
	@ApiOperation(value = "전체 건물의 리뷰 리스트를 반환한다.", response = List.class)
	@GetMapping("/review/")
	public ResponseEntity<List<Review>> searchReviewAll() throws SQLException {
		logger.debug("searchReviewAll - 호출");
		return new ResponseEntity<>(rsvc.selectAll(), HttpStatus.OK);
	}
	
	@ApiOperation(value = "{aptCode} 건물의 리뷰 리스트를 반환한다.", response = List.class)
	@GetMapping("/review/{aptCode}")
	public ResponseEntity<List<Review>> searchReview(@PathVariable int aptCode) throws SQLException {
		logger.debug("searchReview - 호출");
		return new ResponseEntity<>(rsvc.select(aptCode), HttpStatus.OK);
	}
	
	@ApiOperation(value = "{aptCode} 건물의 리뷰 리스트를 삽입한다.", response = List.class)
	@PostMapping("/review/{aptCode}")
	public ResponseEntity<Integer> insertReview(@PathVariable int aptCode, @RequestBody Review review) throws SQLException {
		logger.debug("insertReview - 호출");
		int result = rsvc.insert(review);
		usvc.updateIsReview(review.getUserid());
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
	
	@ApiOperation(value = "{aptCode} 건물의 리뷰 리스트를 삭제한다.", response = List.class)
	@DeleteMapping("/review/{aptCode}")
	public ResponseEntity<Integer> deleteReview(@PathVariable int aptCode, @RequestBody String userid) throws SQLException {
		logger.debug("deleteReview - 호출");
		int result = rsvc.delete(userid,aptCode);
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
	
	@ApiOperation(value = "{aptCode} 건물의 리뷰 리스트를 수정한다.", response = List.class)
	@PutMapping("/review/{aptCode}")
	public ResponseEntity<Integer> updateReview(@PathVariable int aptCode, @RequestBody String userid) throws SQLException {
		logger.debug("updateReview - 호출");
		int result = rsvc.update(userid,aptCode);
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
	
	
	@ApiOperation(value = "{dongCode} 평균 가격을 확인한다.", response = List.class)
	@GetMapping("/avg/{dongCode}")
	public ResponseEntity<Map<String, List<Avgamount>>> getAvg(@PathVariable String dongCode) throws SQLException {
		Map<String, List<Avgamount>> result=new HashMap<>();
		result.put("all", hsvc.getAvgAll());
		result.put("sido", hsvc.getAvgSido(dongCode));
		result.put("gugun", hsvc.getAvgGugun(dongCode));
		result.put("dong", hsvc.getAvgDong(dongCode));
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
	
	
}