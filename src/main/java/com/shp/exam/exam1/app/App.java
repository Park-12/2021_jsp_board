package com.shp.exam.exam1.app;

import com.shp.exam.exam1.container.Container;
import com.shp.mysqlutil.MysqlUtil;

public class App {
	public static boolean isDevMode() {
		// false로 바꾸면 production 모드
		return true;
	}

	public static void init() {
		// DB세팅
		MysqlUtil.setDBInfo("localhost", "sbsst", "sbs123414", "jsp_board");
		MysqlUtil.setDevMode(isDevMode());
		
		// 공용 객체 세팅
		Container.init();
	}
}
