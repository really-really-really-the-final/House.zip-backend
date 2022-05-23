package com.ssafy.happy.controller;

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
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.happy.dto.InterestDeal;
import com.ssafy.happy.dto.User;
import com.ssafy.happy.model.service.InterestDealService;
import com.ssafy.happy.model.service.UserService;

import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins = { "*" }, maxAge = 6000)
@RestController
@RequestMapping("/user")
public class UserRestController {
	private static final Logger logger = LoggerFactory.getLogger(UserRestController.class);
	private static final String SUCCESS = "success";
	private static final String FAIL = "fail";
	
	@Autowired
	UserService usvc;
	
	@Autowired
	InterestDealService isvc;

//	@ApiOperation(value = "등록된 모든 사용자 정보를 반환한다.", response = User.class)
//	@GetMapping("/")
//	public ResponseEntity<?> selectAll() {
//		try {
//			List<User> users = usvc.selectAll();
//			if (users != null && users.size() > 0) {
//				return new ResponseEntity<List<User>>(users, HttpStatus.OK);
//			} else {
//				return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
//			}
//		} catch (Exception e) {
//			return exceptionHandling(e);
//		}
//	}
	
	@ApiOperation(value = "로그인을 한다. 그리고 DB조회 성공여부에 따라 'success' 또는 'fail' 문자열을 반환한다.", response = User.class)
	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody User user) {
		try {
			User selected = usvc.select(user.getId());
			if (selected != null && user.getPassword().equals(selected.getPassword())) {
//				session.setAttribute("loginUser", selected);
				return new ResponseEntity<User>(selected, HttpStatus.OK);
			} else {
				return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
			}
		} catch (Exception e) {
			return exceptionHandling(e);
		}
	}

	@ApiOperation(value = "{id}에 해당하는 사용자 정보를 반환한다.", response = User.class)
	@GetMapping("/{id}")
	public ResponseEntity<?> select(@PathVariable String id) {
		try {
			User user = usvc.select(id);
			if (user != null) {
				return new ResponseEntity<User>(user, HttpStatus.OK);
			} else {
				return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
			}
		} catch (Exception e) {
			return exceptionHandling(e);
		}
	}
	
	@ApiOperation(value = "{id}에 해당하는 사용자 관심사를 반환한다.", response = String.class)
	@GetMapping("/cate/{id}")
	public ResponseEntity<?> selectCate(@PathVariable String id) {
		try {
//			String  = ;
//			if (user != null) {
				return new ResponseEntity<String>(usvc.selectCate(id), HttpStatus.OK);
//			} else {
//				return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
//			}
		} catch (Exception e) {
			return exceptionHandling(e);
		}
	}

	@ApiOperation(value = "사용자 정보를 삽입한다.", response = Integer.class)
	@PostMapping("/")
	public ResponseEntity<?> insert( @RequestBody User user) {
		try {
			System.out.println(user.getCategory());
			int result = usvc.insert(user);
			return new ResponseEntity<Integer>(result, HttpStatus.CREATED);

		} catch (Exception e) {
			return exceptionHandling(e);
		}
	}

	@ApiOperation(value = "{id} 에 해당하는 사용자 정보를 수정한다.", response = Integer.class)
	@PutMapping("/{id}")
	public ResponseEntity<?> update(@PathVariable String id, @RequestBody User user) {
		try {
			int result = usvc.update(user);
			return new ResponseEntity<Integer>(result, HttpStatus.OK);

		} catch (Exception e) {
			return exceptionHandling(e);
		}
	}
	
	@ApiOperation(value = "{id} 에 해당하는 사용자 정보를 삭제한다.", response = Integer.class)
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable String id) {
		try {
			int result = usvc.delete(id);
			return new ResponseEntity<Integer>(result, HttpStatus.OK);

		} catch (Exception e) {
			return exceptionHandling(e);
		}
	}
	
	private ResponseEntity<String> exceptionHandling(Exception e) {
		e.printStackTrace();
		return new ResponseEntity<String>("Sorry: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ApiOperation(value = "{id}에 해당하는 사용자 관심매물 리스트를 반환한다.", response = List.class)
	@GetMapping("/interest/{id}")
	public ResponseEntity<?> selectInterestDeal(@PathVariable String id) {
		try {
			return new ResponseEntity<List<InterestDeal>>(isvc.select(id), HttpStatus.OK);
		} catch (Exception e) {
			return exceptionHandling(e);
		}
	}
	
	@ApiOperation(value = "{id}에 해당하는 사용자 관심매물을 삭제한다.", response = Integer.class)
	@DeleteMapping("/interest/")
	public ResponseEntity<?> deleteInterestDeal(@RequestBody InterestDeal interestDeal) {
		try {
			return new ResponseEntity<Integer>(isvc.delete(interestDeal), HttpStatus.OK);
		} catch (Exception e) {
			return exceptionHandling(e);
		}
	}
	
	@ApiOperation(value = "{id}에 해당하는 사용자 관심매물을 추가한다.", response = Integer.class)
	@PostMapping("/interest/")
	public ResponseEntity<?> postInterestDeal(@RequestBody InterestDeal interestDeal) {
		try {
			return new ResponseEntity<Integer>(isvc.insert(interestDeal), HttpStatus.OK);
		} catch (Exception e) {
			return exceptionHandling(e);
		}
	}
	
	@ApiOperation(value = "전체 사용자 관심매물 리스트를 반환한다.", response = List.class)
	@GetMapping("/interest/")
	public ResponseEntity<?> selectAllInterestDeal() {
		try {
			return new ResponseEntity<List<InterestDeal>>(isvc.selectAll(), HttpStatus.OK);
		} catch (Exception e) {
			return exceptionHandling(e);
		}
	}
}