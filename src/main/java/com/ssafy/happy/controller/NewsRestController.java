package com.ssafy.happy.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.happy.dto.News;
import com.ssafy.happy.dto.Notice;

import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins = { "*" }, maxAge = 6000)
@RestController
@RequestMapping("/crawling")
public class NewsRestController {
	private static final Logger logger = LoggerFactory.getLogger(NewsRestController.class);

	@ApiOperation(value = "뉴스 리스트의 정보를 반환한다.", response = List.class)
	@GetMapping("/")
	public ResponseEntity<List<News>> crawl() throws IOException {
		logger.debug("crawl - 시작");
		
		Calendar calendar = new GregorianCalendar();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy.MM.dd", Locale.KOREA);

		String toDate = formatter.format(calendar.getTime());
		calendar.add(Calendar.DATE, -1);
		String yesDate = formatter.format(calendar.getTime());

		String s_from = yesDate.replace(".", "");
		String e_to = toDate.replace(".", "");
		int page = 1;

		List<News> news = new ArrayList<>();

		String address = "https://search.naver.com/search.naver?where=news&query=부동산매물&sort=1&ds=" + yesDate + "&de="
				+ toDate + "&nso=so%3Ar%2Cp%3Afrom" + s_from + "to" + e_to + "%2Ca%3A&start=" + Integer.toString(page);
		Document rawData = Jsoup.connect(address).timeout(5000).get();

//		System.out.println(address);
		Elements blogOption = rawData.select(".news_area");
		
		String title = "";
		String content = "";
		String time = "";
		String url = "";
		
//		System.out.println("[" + blogOption + "]");
		int cnt=0;
		for (Element option : blogOption) {
//			System.out.println("[" + blogOption + "]");
			title = option.select(".news_tit").text();
			if(35<title.length())continue;
//			content = option.select(".dsc_wrap").text();
			time = option.select(".info").get(1).text();
			for(Element info:option.select(".info")) {
				if(info.text().substring(info.text().length()-1).equals("전")) {
					time = info.text();
					break;
				}
			}
			url = option.select(".news_tit").attr("href");

			news.add(new News(title, "", time, url));

			if(++cnt==5)break;
//			News n = new News(title, content,time , url);
//			System.out.println(n);
//			break;
		}
	
		return new ResponseEntity<>(news, HttpStatus.OK);
	}

}


