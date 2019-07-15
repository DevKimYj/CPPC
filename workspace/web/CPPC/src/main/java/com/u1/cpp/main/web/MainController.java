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
  * @작성자 : Include
  * @변경이력 :
  * @프로그램 설명 : main화면 컨트롤러
 */
@Controller
public class MainController {
	
	private static final Logger logger = LoggerFactory.getLogger(MainController.class);
	
	/**
	  * @Method Name : main
	  * @작성일 : 2019. 7. 14.
	  * @작성자 : Include
	  * @변경이력 : 
	  * @Method 설명 : main화면을 보여줍니다.
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
