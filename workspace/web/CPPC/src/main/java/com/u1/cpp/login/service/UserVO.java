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
	private String userId;		//아이디
	private String userPw;		//비밀번호
	private String userEmail;	//메일 정보
	private String authKey;		//메일인증 인증키
	private String authstatus;	//인증 상태
	
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
