package com.tenco.listeners;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Logger;

import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;

/*
 * 리스너 사용해 보기.
 * ServletContext implements(구현) 해야함.
 * 동작 트리거 설정이 필요 - web.xml 파일과 어노테이션으로 설정 가능
 */

public class AppLifecycleListener implements ServletContextListener {

	private static final Logger logger = 
			Logger.getLogger(AppLifecycleListener.class.getName());
			// "AppLifecycleListener" 이랑 같음.
	
	// formatter 클래스 만들어보기
	private String timeFormat() {
		String datePattern = "yyyy-MM-dd HH:mm:ss";
		SimpleDateFormat format = new SimpleDateFormat(datePattern);
		return format.format(new Date());
	}
	
	// 애플리케이션이 언제 시작했는지 로그나 파일로 남겨야 할 때가 있음. 해당 상황을 가정하여 코드 작성해보기.
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("-----------------------------");
		logger.info("웹 애플리케이션 시작됨 >>>>> " + timeFormat());
		System.out.println("-----------------------------");
	}
	
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("-----------------------------");
		logger.info("웹 애플리케이션 종료됨 >>>>> " + timeFormat());
		System.out.println("-----------------------------");
	}
	
	
}
