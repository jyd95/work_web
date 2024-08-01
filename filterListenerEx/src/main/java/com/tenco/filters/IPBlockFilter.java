package com.tenco.filters;

import java.io.IOException;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;

/*
 * 1. Filter 구현
 * 2. URL 패턴 설정 (web.xml에서 해보기)
 */

public class IPBlockFilter implements Filter{
	
	// 192.168.0.140 <-- 내 아이피
	
	// 차단할 IP의 접두사
	private static final String BLODCKED_IP_PREFIX = "192.168.0.25";
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("IPBlockFilter 초기화 "); 
	}
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		// 전처리 - 요청자의 ip를 확인
		String remoteIP = request.getRemoteAddr();
		System.out.println("Request from IP : " + remoteIP);
		
		// 차단 시킬 코드 작성
		if(remoteIP.startsWith(BLODCKED_IP_PREFIX)) {
			System.out.println("영준 ip 차단.");
			response.setContentType("text/plain;charset=UTF-8");
			response.getWriter().println("Access Deny!");
			response.getWriter().println("차단된 IP 사용자 입니다.");
			return;
		}
		
		chain.doFilter(request, response);
		
	}
	
}
