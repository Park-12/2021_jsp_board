package com.shp.exam.exam1.container;

import com.shp.exam.exam1.http.controller.UsrArticleController;
import com.shp.exam.exam1.http.controller.UsrMemberController;
import com.shp.exam.exam1.repository.ArticleRepository;
import com.shp.exam.exam1.repository.MemberRepository;
import com.shp.exam.exam1.service.ArticleService;
import com.shp.exam.exam1.service.MemberService;

public class Container {
	public static ArticleRepository articleRepository;
	public static ArticleService articleService;
	public static UsrArticleController usrArticleController;

	public static MemberRepository memberRepository;
	public static MemberService memberService;
	public static UsrMemberController usrMemberController;
	
	public static void init() {
		articleRepository = new ArticleRepository();
		articleService = new ArticleService();
		usrArticleController = new UsrArticleController();
		
		memberRepository = new MemberRepository();
		memberService = new MemberService();
		usrMemberController = new UsrMemberController();
	}
}