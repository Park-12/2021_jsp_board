package com.shp.exam.exam1.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shp.exam.exam1.container.Container;
import com.shp.exam.exam1.http.Rq;
import com.shp.exam.exam1.http.controller.Controller;
import com.shp.exam.exam1.http.controller.UsrArticleController;
import com.shp.mysqlutil.MysqlUtil;


@WebServlet("/usr/*")
public class DispatcherServlet extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
		Rq rq = new Rq(req, resp);
		
		if ( rq.isInvalid() ) {
			rq.print("올바른 요청이 아닙니다.");
		}
		
		Controller controller = null;		
		
		switch ( rq.getControllerTypeName() ) {
		case "usr":
			switch (rq.getControllerName()) {
			case "article":
				controller = Container.usrArticleController;
				break;
			case "member":
				controller = Container.usrMemberController;
				break;
			}
			break;
		}
		
		if (controller != null) {
			controller.performAction(rq);
			
			MysqlUtil.closeConnection();
		}
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}