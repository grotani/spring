package com.gd.article.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class loginController {
	@GetMapping("/public/login") // 로그인 폼 
	public String login() {	
		return "/public/login";	
	}
	
	@PostMapping("/public/login") // 로그인 액션 
	public String login(HttpSession session,
			@RequestParam (name = "id") String id,
			@RequestParam (name = "pw") String pw) {
		final String OnId = "admin";
		final String OnPw = "1234";
		if(id.equals(OnId) && pw.equals(OnPw)) {
			log.debug("로그인성공");
			session.setAttribute("loginUser", id);
			// 회원접속 카운팅 ++1 -> 이미 존재하는 application 변수가 리요 
		}		
		return "redirect:/auth/on";
	}
	
	@GetMapping("/logout") // 
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/public/login";
	}
	
	@GetMapping("/auth/on") // 로그인 된 화면 
	public String on() {
		return "auth/on";
	}
	
}

