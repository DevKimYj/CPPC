package com.u1.cpp.login.service;

import com.u1.cpp.common.SecurityUtil;

/**
  * @FileName : UserVO.java
  * @Project : CPPC
  * @Date : 2019. 7. 17. 
  * @작성자 : Include
  * @변경이력 :
  * @프로그램 설명 : 사용자 정보
 */
public class UserVO {
	private String userId;
	private String userPw;
	private String userEmail;
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
}
