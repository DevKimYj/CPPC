package com.u1.cpp.login.service;

public interface LoginService {
	/**
	  * @Method Name : loginCheck
	  * @작성일 : 2019. 7. 17.
	  * @작성자 : Include
	  * @변경이력 : 
	  * @Method 설명 : 로그인 요청 검사
	  * @return
	  * @throws Exception
	 */
	UserVO loginCheck(UserVO userVo) throws Exception;

	void createUser(UserVO userVo) throws Exception;
}
