package com.shp.exam.exam1.http.controller;

import com.shp.exam.exam1.container.Container;
import com.shp.exam.exam1.dto.Member;
import com.shp.exam.exam1.dto.ResultData;
import com.shp.exam.exam1.http.Rq;
import com.shp.exam.exam1.service.MemberService;
import com.shp.exam.exam1.util.Ut;

public class UsrMemberController extends Controller {
	private MemberService memberService = Container.memberService;

	@Override
	public void performAction(Rq rq) {
		switch (rq.getActionMethodName()) {
		case "login":
			actionShowLogin(rq);
			break;
		case "doLogin":
			actionDoLogin(rq);
			break;
		default:
			rq.println("존재하지 않는 페이지 입니다.");
			break;
		}
	}

	private void actionDoLogin(Rq rq) {
		String loginId = rq.getParam("loginId", "");
		String loginPw = rq.getParam("loginPw", "");

		if (loginId.length() == 0) {
			rq.historyBack("loginId를 입력해주세요.");
			return;
		}

		if (loginPw.length() == 0) {
			rq.historyBack("loginPw를 입력해주세요.");
			return;
		}

		ResultData loginRd = memberService.login(loginId, loginPw);

		if (loginRd.isFail()) {
			rq.historyBack(loginRd.getMsg());
		}

		Member member = (Member) loginRd.getBody().get("member");

		rq.setSessionAttr("loginedMemberJson", Ut.toJson(member, ""));
		rq.replace(loginRd.getMsg(), "../article/list");
	}

	private void actionShowLogin(Rq rq) {
		rq.jsp("usr/member/login");
	}
}