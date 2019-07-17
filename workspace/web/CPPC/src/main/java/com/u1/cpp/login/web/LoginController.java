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
  * @작성자 : Include
  * @변경이력 :
  * @프로그램 설명 : login화면 컨트롤러
 */
@Controller
public class LoginController {
	
	private static final Logger logger = LoggerFactory.getLogger(MainController.class);
	//참고 https://thiago6.tistory.com/38
	/** 
	  * @Method Name : loginView
	  * @작성일 : 2019. 7. 14.
	  * @작성자 : Include
	  * @변경이력 : 
	  * @Method 설명 : login화면을 보여줍니다.
	  * @param model
	  * @return
	 */
	@RequestMapping(value = "/login.cpp")
	public String loginView(Model model) {
		return "";
	}
}
