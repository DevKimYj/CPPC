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
	private String userNo;		//����� ���� ��ȣ
	private String userId;		//���̵�
	private String userPw;		//��й�ȣ
	private String userEmail;	//���� ����
	private String userName;	//����� �̸�
	private String authKey;		//�������� ����Ű
	private String authStatus;	//���� ����
	
	public String getUserNo() {
		return userNo;
	}
	public void setUserNo(String userNo) {
		this.userNo = userNo;
	}
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
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getAuthKey() {
		return authKey;
	}
	public void setAuthKey(String authKey) {
		this.authKey = authKey;
	}
	public String getAuthStatus() {
		return authStatus;
	}
	public void setAuthStatus(String authStatus) {
		this.authStatus = authStatus;
	}
}
