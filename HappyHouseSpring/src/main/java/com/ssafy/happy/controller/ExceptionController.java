package com.ssafy.happy.controller;

import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.NoHandlerFoundException;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@ControllerAdvice
public class ExceptionController {
	@ExceptionHandler(Exception.class)
	public String handleException(Exception e,Model m){
		log.error("예외처리: ", e.getCause());
		m.addAttribute("errmsg", "처리중 에러 발생!!!");
		if(e instanceof BindException) {
			m.addAttribute("errmsg", "파라미터가 잘 전달되었는지 확인하세요.");
		}
		e.printStackTrace();
		return "error/500";
	}
	@ExceptionHandler(NoHandlerFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public String handle404(NoHandlerFoundException e, Model m) {
		log.error("404 발생 : {}", "404 page not found");
		m.addAttribute("errmsg", "요청하신 파일은 존재하지 않습니다.");
		return "error/404";
	}
}
