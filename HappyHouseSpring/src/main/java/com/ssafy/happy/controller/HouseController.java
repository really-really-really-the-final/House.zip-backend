package com.ssafy.happy.controller;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ssafy.happy.dto.House;
import com.ssafy.happy.dto.SearchCondition;
import com.ssafy.happy.model.service.HouseService;

@Controller
@RequestMapping("/house")
public class HouseController {

	@Autowired
	HouseService hsvc;

	@GetMapping("all")
	public String all() throws SQLException {
		return "house/all";
	}
	
	@PostMapping("/all")
	public String all(SearchCondition condition, Model m) throws SQLException {
//		public String all(String gugun, Model m) throws SQLException {
//		List<House> houses = hsvc.selectGugun(gugun);
//		m.addAttribute("houses", houses);
//		return "house/all";
		Map<String, Object> map = hsvc .pagingSearch(condition);
		m.addAttribute("houses", map.get("houses"));
		m.addAttribute("navigation", map.get("navigation"));
		return "house/all";
	}

	@GetMapping("/dong")
	public String dongSearch() throws SQLException {
		return "house/dong";
	}
	
	@GetMapping("/apt")
	public String aptSearch() throws SQLException {
		return "house/apt";
	}
	
	@PostMapping("/dong")
	public String dongList(String dong,Model m) throws SQLException {
//		List<House> donglist = hsvc.selectDong(dong);
//		m.addAttribute("donglist", donglist);
		return "house/dong";
	}
	
	@PostMapping("/apt")
	public String aptList(String aptName,Model m) throws SQLException {
//		List<House> aptlist = hsvc.selectApt(aptName);
//		m.addAttribute("aptlist", aptlist);
		return "house/apt";
	}
	
	@GetMapping("/view")
	public String view(int no, Model m) throws SQLException {
		House house = hsvc.select(no);
		m.addAttribute("house", house);
		return "house/detail";
	}


}