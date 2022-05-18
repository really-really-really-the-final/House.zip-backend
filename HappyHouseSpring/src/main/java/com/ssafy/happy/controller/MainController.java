package com.ssafy.happy.controller;

import java.sql.SQLException;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

//@Controller
public class MainController {

//	@GetMapping({ "/", "/index" })
	public String index(HttpSession session) {
		return "index";
	}
//	@GetMapping("/intro")
	public String intro(Model m) throws SQLException {
		return "intro";
	}
}