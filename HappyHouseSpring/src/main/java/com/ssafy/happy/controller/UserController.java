package com.ssafy.happy.controller;

import java.sql.SQLException;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ssafy.happy.dto.User;
import com.ssafy.happy.model.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	UserService usvc;

	@GetMapping("/login")
	public String login() {
		return "user/login";
	}

	@PostMapping("/login")
	public String login(User user, HttpSession session, Model m) throws SQLException {
		User selected = usvc.select(user.getId());
		if (selected != null && user.getPassword().equals(selected.getPassword())) {
			session.setAttribute("loginUser", selected);
			return "redirect:/";
		} else {
			m.addAttribute("msg", "로그인 실패");
			return "user/login";
		}
	}

	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}

	@GetMapping("/regist")
	public String regist() {
		return "user/regist";
	}

	@PostMapping("/regist")
	public String regist(User user, RedirectAttributes re) throws SQLException {
		usvc.insert(user);
		re.addFlashAttribute("msg", "회원가입 성공");
		return "redirect:/";
	}

	@GetMapping("/findpwd")
	public String findpwd() {
		return "user/findpwd";
	}

	@PostMapping("/findpwd")
	public String findpwd(User user, Model m, HttpSession session, RedirectAttributes re) throws SQLException {
		User selected = usvc.select(user.getId());
		if (selected != null && user.getName().equals(user.getName()) && user.getTel().equals(user.getTel())) {
			selected.setPassword("1234");
			usvc.update(selected);
			re.addFlashAttribute("msg", "비밀번호가 1234로 초기화 되었습니다.");
			return "redirect:/";
		} else {
			m.addAttribute("msg", "회원인증 실패");
			return "user/findpwd";
		}
	}

	@GetMapping("/mypage")
	public String mypage(Model m, HttpSession session) throws SQLException {
		User user = (User) session.getAttribute("loginUser");
		m.addAttribute("user", user);
		return "user/mypage";
	}

	@GetMapping("/rmuser")
	public String rmuser(Model m, RedirectAttributes re, HttpSession session) throws SQLException {
		User user = (User) session.getAttribute("loginUser");
		usvc.delete(user.getId());
		re.addFlashAttribute("msg", "탈퇴되었습니다.");
//		return "redirect:/user/logout";
		session.invalidate();
		return "redirect:/";
	}

	@PostMapping("/modify")
	public String modify(User user, RedirectAttributes re, HttpSession session) throws SQLException {
		usvc.update(user);
		session.setAttribute("loginUser", user);
		re.addFlashAttribute("msg", "정보를 수정했습니다.");
		return "redirect:/";
	}	

}