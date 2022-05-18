package com.ssafy.happy.controller;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ssafy.happy.algo.Algo;
import com.ssafy.happy.dto.Notice;
import com.ssafy.happy.dto.User;
import com.ssafy.happy.model.service.NoticeService;

@Controller
@RequestMapping("/notice")
public class NoticeController {
	
	@Autowired
	NoticeService nsvc;

	@GetMapping("/")
	public String notice(Model m, HttpSession session) throws SQLException {
		List<Notice> notices = nsvc.selectAll();
		//알고리즘 적용 (정렬-merge sort)
		if(notices!=null && 1<notices.size())notices=Algo.sort(notices);
		m.addAttribute("notices", notices);
		if (session != null)
			m.addAttribute("ism", ((User) session.getAttribute("loginUser")).isManager());
		return "notice/notice";
	}

	@GetMapping("/detail")
	public String detail(int no, Model m, HttpSession session) throws SQLException {
		Notice notice = nsvc.select(no);
		m.addAttribute("notice", notice);
		notice.setContent(notice.getContent().replace("\r\n", "<br>"));
		if (session != null)
			m.addAttribute("ism", ((User) session.getAttribute("loginUser")).isManager());
		return "notice/detail";
	}

	@GetMapping("/write")
	public String write() throws SQLException {
		return "notice/write";
	}

	@GetMapping("/delete")
	public String delete(String wrid, int no, HttpSession session, RedirectAttributes re) throws SQLException {
		User user = (User) session.getAttribute("loginUser");
		if (wrid.equals(user.getId())) {
			nsvc.delete(no);
			re.addFlashAttribute("msg", "삭제했습니다.");
		} else {
			re.addFlashAttribute("msg", "본인이 작성한 글이 아닙니다.");
		}
		return "redirect:/notice/";
	}

	@PostMapping("/save")
	public String save(Notice notice, HttpSession session, RedirectAttributes re) throws SQLException {
		User user = (User) session.getAttribute("loginUser");
		notice.setUserId(user.getId());
		nsvc.insert(notice);
		re.addFlashAttribute("msg", "공지등록 성공");
		return "redirect:/notice/";

	}
	
	@GetMapping("/modify")
	public String modify(String wrid, int no, HttpSession session, Model m, RedirectAttributes re) throws SQLException {
		User user = (User) session.getAttribute("loginUser");
		if (wrid.equals(user.getId())) {
			Notice notice = nsvc.select(no);
			m.addAttribute("notice", notice);
			return "notice/modify";
		} else {
			re.addFlashAttribute("msg", "본인이 작성한 글이 아닙니다.");
			return "redirect:/notice/";
		}
	}

	@PostMapping("/modify")
	public String modify(Notice notice, int no, HttpSession session, Model m, RedirectAttributes re) throws SQLException {

		User user = (User) session.getAttribute("loginUser");
		notice.setUserId(user.getId());
		notice.setNo(no);
		nsvc.update(notice);
		re.addFlashAttribute("msg", "공지수정 성공");
		return "redirect:/notice/";
	}

}