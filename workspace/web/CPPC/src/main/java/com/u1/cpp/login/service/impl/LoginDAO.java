package com.u1.cpp.login.service.impl;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.u1.cpp.login.service.UserVO;

@Repository("loginDAO")
public class LoginDAO {

	@Autowired
	private SqlSession sql;
	
	public UserVO loginCheck(UserVO userVo) throws Exception{
		return sql.selectOne("loginMapper.selectMember", userVo);
	}

	public void createUser(UserVO userVo) throws Exception{
		sql.insert("loginMapper.createUser", userVo);
	}

}
