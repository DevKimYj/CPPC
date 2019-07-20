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

	/**
	  * @Method Name : createUser
	  * @�ۼ��� : 2019. 7. 20.
	  * @�ۼ��� : Include
	  * @�����̷� : 
	  * @Method ���� : ȸ������ ���� ����
	  * @param userVo
	  * @throws Exception
	 */
	void createUser(UserVO userVo) throws Exception;

	/**
	  * @Method Name : userConfirm
	  * @�ۼ��� : 2019. 7. 20.
	  * @�ۼ��� : Include
	  * @�����̷� : 
	  * @Method ���� : �̸��� ���� ��û �Ϸ�ó��
	  * @param userVo
	  * @throws Exception
	 */
	void userConfirm(UserVO userVo) throws Exception;
}
