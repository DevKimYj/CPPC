package com.u1.cpp.login.service;

/**
  * @FileName : UserVO.java
  * @Project : CPPC
  * @Date : 2019. 7. 17. 
  * @작성자 : Include
  * @변경이력 :
  * @프로그램 설명 : 사용자 정보
 */
public class UserVO {
	private String userNo;		//사용자 고유 번호
	private String userId;		//아이디
	private String userPw;		//비밀번호
	private String userEmail;	//메일 정보
	private String userName;	//사용자 이름
	private String authKey;		//메일인증 인증키
	private String authStatus;	//인증 상태
	
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
		this.userPw = userPw;
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
