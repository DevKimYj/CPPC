package com.u1.cpp.login.service;

import com.u1.cpp.common.SecurityUtil;

/**
  * @FileName : UserVO.java
  * @Project : CPPC
  * @Date : 2019. 7. 17. 
  * @�ۼ��� : Include
  * @�����̷� :
  * @���α׷� ���� : ����� ����
 */
public class UserVO {
	private String userId;		//���̵�
	private String userPw;		//��й�ȣ
	private String userEmail;	//���� ����
	private String authKey;		//�������� ����Ű
	private String authstatus;	//���� ����
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserPw() {
		return userPw;
	}
	public void setUserPw(String userPw) {
		SecurityUtil su = new SecurityUtil();
		this.userPw = su.encryptSHA256(userPw);
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public String getAuthKey() {
		return authKey;
	}
	public void setAuthKey(String authKey) {
		this.authKey = authKey;
	}
	public String getAuthstatus() {
		return authstatus;
	}
	public void setAuthstatus(String authstatus) {
		this.authstatus = authstatus;
	}
	
}
