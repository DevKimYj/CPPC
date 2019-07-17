package com.u1.cpp.login.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.u1.cpp.login.service.LoginService;
import com.u1.cpp.login.service.UserVO;

@Service("loginService")
public class LoginServiceImpl implements LoginService {

	/** loginDAO */
	@Resource(name = "loginDAO")
	private LoginDAO dao;
	
	@Override
	public UserVO loginCheck(UserVO userVo) throws Exception {
		return dao.loginCheck(userVo);
	}

}
