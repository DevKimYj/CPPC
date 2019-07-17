package com.u1.cpp.login.web;

import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.u1.cpp.main.web.MainController;

/**
  * @FileName : LoginController.java
  * @Project : CPPC
  * @Date : 2019. 7. 14. 
  * @�ۼ��� : Include
  * @�����̷� :
  * @���α׷� ���� : loginȭ�� ��Ʈ�ѷ�
 */
@Controller
public class LoginController {
	
	private static final Logger logger = LoggerFactory.getLogger(MainController.class);
	//���� https://thiago6.tistory.com/38
	/** 
	  * @Method Name : loginView
	  * @�ۼ��� : 2019. 7. 14.
	  * @�ۼ��� : Include
	  * @�����̷� : 
	  * @Method ���� : loginȭ���� �����ݴϴ�.
	  * @param model
	  * @return
	 */
	@RequestMapping(value = "/login.cpp")
	public String loginView(Model model) {
		return "";
	}
}
