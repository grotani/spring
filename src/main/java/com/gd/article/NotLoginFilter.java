package com.gd.article;

import java.io.IOException;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

// @WebFilter 어떤 URL에 패턴에 적용되어야 하는지를 정의 하는것 
@WebFilter("/public/*")
public class NotLoginFilter implements Filter {
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("/public/*");
		// 요청 전 
		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse res = (HttpServletResponse)response;
		HttpSession session = req.getSession();
		if(session.getAttribute("loginUser") != null) { // 이미 로그인 되어있으면 
			res.sendRedirect(req.getContextPath()+"auth/on");
			return;
		}

	}
}
