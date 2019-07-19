package com.u1.cpp.login.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;

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
	public void createUser(UserVO userVo) throws Exception {
		
		// mail 작성 관련 
		MailUtil sendMail = new MailUtil(mailSender);

		//이메일 인증키 생성
		String authKey = sendMail.getKey(50, false);

		//메일 인증키
		userVo.setAuthKey(authKey);
		
		//메일 인증 상태(아직 인증 전이므로 False)
		userVo.setAuthstatus("F");

		//사용자 고유번호 생성
		long tm = System.currentTimeMillis();
		SimpleDateFormat dayTime = new SimpleDateFormat("yyMMddHHmmssSSS"); 
		String userNo = dayTime.format(new Date(tm));
		userVo.setUserNo(userNo);
		
		//DB에 사용자 정보 생성
		dao.createUser(userVo);
		
		//메일 타이틀
		sendMail.setSubject("[Pursue to CPP] 회원가입 이메일 인증");

		//메일 내용
		sendMail.setText(new StringBuffer().append("<h1>[이메일 인증]</h1>")
				.append("<p>아래 링크를 클릭하시면 이메일 인증이 완료됩니다.</p>")
				.append("<a href='http://localhost:8080/login/joinConfirm.cpp?userId=")
				.append(userVo.getUserId())
				.append("&userEmail=")
				.append(userVo.getUserEmail())
				.append("&authKey=")
				.append(authKey)
				.append("' target='_blank'>이메일 인증 확인</a>")
				.toString());

		//발송 메일 정보(메일주소, 메일 사용자 이름)
		sendMail.setFrom("pursue.to.cpp@gmail.com", "CPPC");

		//수신 메일 주소
		sendMail.setTo(userVo.getUserEmail());

		//메일 발송
		sendMail.send();
		
	}

}
