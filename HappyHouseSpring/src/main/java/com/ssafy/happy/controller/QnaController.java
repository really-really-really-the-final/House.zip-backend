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

import com.ssafy.happy.dto.Notice;
import com.ssafy.happy.dto.Qna;
import com.ssafy.happy.dto.User;
import com.ssafy.happy.model.service.QnaService;

@Controller
@RequestMapping("qna")
public class QnaController {

	@Autowired
	QnaService qsvc;

	@GetMapping("/")
	public String notice(Model m, HttpSession session) throws SQLException {
		List<Qna> qnas = qsvc.selectAll();

		m.addAttribute("qnas", qnas);
		if (session != null)
			m.addAttribute("ism", ((User) session.getAttribute("loginUser")).isManager());
		return "qna/qna";
	}

	@GetMapping("/detail")
	public String detail(int no, Model m, HttpSession session, RedirectAttributes re) throws SQLException {
		if (session != null) {
			User user = (User) session.getAttribute("loginUser");
			Qna qna = qsvc.select(no);
			if (user.isManager() || qna.getUserId().equals(user.getId())) {
				m.addAttribute("qna", qna);
				m.addAttribute("ism", user.isManager());
				qna.setContent(qna.getContent().replace("\r\n", "<br>"));
				if (qna.getAnscontent() != null)
					qna.setAnscontent(qna.getAnscontent().replace("\r\n", "<br>"));
				return "qna/detail";
			}
		}
		re.addFlashAttribute("msg", "본인이 작성한 글이 아닙니다.");
		return "redirect:/qna/";

	}

	@GetMapping("/write")
	public String write() throws SQLException {
		return "qna/write";
	}

	@GetMapping("/writeans")
	public String answrite() throws SQLException {
		return "qna/writeans";
	}

	@GetMapping("/delete")
	public String delete(String wrid, int no, HttpSession session, RedirectAttributes re) throws SQLException {
		User user = (User) session.getAttribute("loginUser");
		if (wrid.equals(user.getId())) {
			qsvc.deleteAsk(no);
			re.addFlashAttribute("msg", "삭제했습니다.");
		} else {
			re.addFlashAttribute("msg", "본인이 작성한 글이 아닙니다.");
		}
		return "redirect:/qna/";
	}

	@GetMapping("/deletans")
	public String deleteAns(String wrid, int no, HttpSession session, RedirectAttributes re) throws SQLException {
		User user = (User) session.getAttribute("loginUser");
		if (user.isManager()) {
			qsvc.deleteAns(no);
			re.addFlashAttribute("msg", "삭제했습니다.");
		} else {
			re.addFlashAttribute("msg", "관리자가 아닙니다.");
		}
		return "redirect:/qna/";
	}

	@PostMapping("/save")
	public String save(Qna qna, HttpSession session, RedirectAttributes re) throws SQLException {
		User user = (User) session.getAttribute("loginUser");
		qna.setUserId(user.getId());
		qsvc.insert(qna);
		re.addFlashAttribute("msg", "공지등록 성공");
		return "redirect:/qna/";
	}

	@GetMapping("/modify")
	public String modify(String wrid, int no, HttpSession session, Model m, RedirectAttributes re) throws SQLException {
		User user = (User) session.getAttribute("loginUser");
		if (wrid.equals(user.getId())) {
			Qna qna = qsvc.select(no);
			m.addAttribute("qna", qna);
			return "qna/modify";
		} else if (user.isManager()) {
			Qna qna = qsvc.select(no);
			m.addAttribute("qna", qna);
			return "notiqnace/modifyans";
		} else {
			re.addFlashAttribute("msg", "본인이 작성한 글이 아닙니다.");
			return "redirect:/qna/";
		}
	}

	@PostMapping("/modify")
	public String modify(Qna qna, int no, HttpSession session, Model m, RedirectAttributes re) throws SQLException {

		User user = (User) session.getAttribute("loginUser");
		qna.setUserId(user.getId());
		qna.setNo(no);
		qsvc.updateAsk(qna);
		re.addFlashAttribute("msg", "공지수정 성공");
		return "redirect:/qna/";
	}

	@PostMapping("/modifyans")
	public String modifyAns(Qna qna, int no, HttpSession session, Model m, RedirectAttributes re) throws SQLException {

		User user = (User) session.getAttribute("loginUser");
		qna.setUserId(user.getId());
		qna.setNo(no);
		qsvc.updateAns(qna);
		re.addFlashAttribute("msg", "공지수정 성공");
		return "redirect:/qna/";
	}

}