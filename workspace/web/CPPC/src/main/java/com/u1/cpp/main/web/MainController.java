package com.u1.cpp.main.web;

import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
  * @FileName : MainController.java
  * @Project : CPPC
  * @Date : 2019. 7. 14. 
  * @�ۼ��� : Include
  * @�����̷� :
  * @���α׷� ���� : mainȭ�� ��Ʈ�ѷ�
 */
@Controller
public class MainController {
	
	private static final Logger logger = LoggerFactory.getLogger(MainController.class);
	
	/**
	  * @Method Name : main
	  * @�ۼ��� : 2019. 7. 14.
	  * @�ۼ��� : Include
	  * @�����̷� : 
	  * @Method ���� : mainȭ���� �����ݴϴ�.
	  * @param locale
	  * @param model
	  * @return
	 */
	@RequestMapping(value = "/main.cpp")
	public String mainView(Locale locale, Model model) {
		logger.debug("call /main.cpp");
		return "main/main";
	}
}
