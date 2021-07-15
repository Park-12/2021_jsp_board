package com.shp.exam.exam1.repository;

import com.shp.exam.exam1.dto.Member;
import com.shp.mysqlutil.MysqlUtil;
import com.shp.mysqlutil.SecSql;

public class MemberRepository {

	public Member getMemberByLoginId(String loginId) {
		SecSql sql = new SecSql();
		sql.append("SELECT M.*");
		sql.append("FROM member AS M");
		sql.append("WHERE M.loginId = ?", loginId);
		
		return MysqlUtil.selectRow(sql, Member.class);
	}

}