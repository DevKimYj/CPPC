package com.u1.cpp.login.service;

public interface LoginService {
	/**
	  * @Method Name : loginCheck
	  * @�ۼ��� : 2019. 7. 17.
	  * @�ۼ��� : Include
	  * @�����̷� : 
	  * @Method ���� : �α��� ��û �˻�
	  * @return
	  * @throws Exception
	 */
	UserVO loginCheck(UserVO userVo) throws Exception;

	void createUser(UserVO userVo) throws Exception;
}
