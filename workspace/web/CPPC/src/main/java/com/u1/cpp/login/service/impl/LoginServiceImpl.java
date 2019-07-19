package com.u1.cpp.login.service.impl;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.u1.cpp.common.MailUtil;
import com.u1.cpp.login.service.LoginService;
import com.u1.cpp.login.service.UserVO;

@Service("loginService")
public class LoginServiceImpl implements LoginService {
	
	@Autowired
	private JavaMailSender mailSender;
	
	/** loginDAO */
	@Resource(name = "loginDAO")
	private LoginDAO dao;
	
	/**
	 * 사용자 인증
	 */
	@Override
	public UserVO loginCheck(UserVO userVo) throws Exception {
		return dao.loginCheck(userVo);
	}

	/**
	 * 사용자 정보 생성
	 */
	@Override
	public void userCreate(UserVO userVo) throws Exception {
		
		//dao.userCreate(userVo);
		
		// mail 작성 관련 
		MailUtil sendMail = new MailUtil(mailSender);

		//이메일 인증키 생성
		String authkey = sendMail.getKey(50, false);

		sendMail.setSubject("[Pursue to CPP] 회원가입 이메일 인증");

		sendMail.setText(new StringBuffer().append("<h1>[이메일 인증]</h1>")
				.append("<p>아래 링크를 클릭하시면 이메일 인증이 완료됩니다.</p>")
				.append("<a href='http://localhost:8080/login/joinConfirm.cpp?userId=")
				.append(userVo.getUserId())
				.append("&userEmail=")
				.append(userVo.getUserEmail())
				.append("&authKey=")
				.append(authkey)
				.append("' target='_blank'>이메일 인증 확인</a>")
				.toString());

		sendMail.setFrom("pursue.to.cpp@gmail.com", "CPPC");

		sendMail.setTo(userVo.getUserEmail());

		sendMail.send();
		
	}

}
