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

	/**
	  * @Method Name : createUser
	  * @작성일 : 2019. 7. 20.
	  * @작성자 : Include
	  * @변경이력 : 
	  * @Method 설명 : 회원가입 정보 생성
	  * @param userVo
	  * @throws Exception
	 */
	void createUser(UserVO userVo) throws Exception;

	/**
	  * @Method Name : userConfirm
	  * @작성일 : 2019. 7. 20.
	  * @작성자 : Include
	  * @변경이력 : 
	  * @Method 설명 : 이메일 인증 요청 완료처리
	  * @param userVo
	  * @throws Exception
	 */
	void userConfirm(UserVO userVo) throws Exception;
}
