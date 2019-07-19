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
	 * ����� ����
	 */
	@Override
	public UserVO loginCheck(UserVO userVo) throws Exception {
		return dao.loginCheck(userVo);
	}

	/**
	 * ����� ���� ����
	 */
	@Override
	public void userCreate(UserVO userVo) throws Exception {
		
		//dao.userCreate(userVo);
		
		// mail �ۼ� ���� 
		MailUtil sendMail = new MailUtil(mailSender);

		//�̸��� ����Ű ����
		String authkey = sendMail.getKey(50, false);

		sendMail.setSubject("[Pursue to CPP] ȸ������ �̸��� ����");

		sendMail.setText(new StringBuffer().append("<h1>[�̸��� ����]</h1>")
				.append("<p>�Ʒ� ��ũ�� Ŭ���Ͻø� �̸��� ������ �Ϸ�˴ϴ�.</p>")
				.append("<a href='http://localhost:8080/login/joinConfirm.cpp?userId=")
				.append(userVo.getUserId())
				.append("&userEmail=")
				.append(userVo.getUserEmail())
				.append("&authKey=")
				.append(authkey)
				.append("' target='_blank'>�̸��� ���� Ȯ��</a>")
				.toString());

		sendMail.setFrom("pursue.to.cpp@gmail.com", "CPPC");

		sendMail.setTo(userVo.getUserEmail());

		sendMail.send();
		
	}

}
