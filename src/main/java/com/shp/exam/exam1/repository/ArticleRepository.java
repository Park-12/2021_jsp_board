package com.shp.exam.exam1.repository;

import java.util.List;

import com.shp.exam.exam1.dto.Article;
import com.shp.mysqlutil.MysqlUtil;
import com.shp.mysqlutil.SecSql;

public class ArticleRepository {
	public int write(String title, String body) {
		SecSql sql = new SecSql();
		sql.append("INSERT INTO article");
		sql.append("SET regDate = NOW()");
		sql.append(", updateDate = NOW()");
		sql.append(", title = ?", title);
		sql.append(", `body` = ?", body);
		
		int id = MysqlUtil.insert(sql);
		
		return id;
	}

	public List<Article> getForPrintArticles() {
		SecSql sql = new SecSql();
		sql.append("SELECT A.*");
		sql.append("FROM article AS A");
		sql.append("ORDER BY id DESC");
		
		return MysqlUtil.selectRows(sql, Article.class);
	}
}