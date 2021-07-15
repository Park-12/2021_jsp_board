package com.shp.exam.exam1.service;

import java.util.List;

import com.shp.exam.exam1.container.Container;
import com.shp.exam.exam1.dto.Article;
import com.shp.exam.exam1.dto.ResultData;
import com.shp.exam.exam1.repository.ArticleRepository;
import com.shp.exam.exam1.util.Ut;

public class ArticleService {
	private ArticleRepository articleRepository = Container.articleRepository;

	public ResultData write(String title, String body) {
		int id = articleRepository.write(title, body);

		return ResultData.from("S-1", Ut.f("%d번 게시물이 생성되었습니다.", id), "id", id);
	}

	public List<Article> getForPrintArticles() {
		return articleRepository.getForPrintArticles();
	}

	public Article getForPrintArticleById(int id) {
		return articleRepository.getForPrintArticleById(id);
	}

	public ResultData delete(int id) {
		articleRepository.delete(id);

		return ResultData.from("S-1", Ut.f("%d번 게시물이 삭제되었습니다.", id), "id", id);
	}

}
