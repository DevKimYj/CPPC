package com.u1.cpp.login.web;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.u1.cpp.common.SecurityUtil;
import com.u1.cpp.login.service.UserVO;
import com.u1.cpp.main.web.MainController;

/**
  * @FileName : LoginController.java
  * @Project : CPPC
  * @Date : 2019. 7. 17. 
  * @작성자 : Include
  * @변경이력 :
  * @프로그램 설명 : login 컨트롤러
 */
@Controller
public class LoginController {

	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
	
	@RequestMapping(value = "/login.cpp")
	public String loginView() {
		return "login/login";
	}
	
	@RequestMapping(value = "/loginCheck.cpp", method=RequestMethod.POST)
	public String loginCheck(UserVO userVo, ModelMap model, HttpServletRequest req, HttpServletResponse res) {
		logger.debug("> loginCheck...");
		if(userVo != null
			&& userVo.getUserId() != null
			&& userVo.getUserPw() != null
			&& !"".equals(userVo.getUserId())
			&& !"".equals(userVo.getUserPw())) {
			//DB에서 사용자 인증여부 확인하는 로직 추가
			
			long userNo = System.currentTimeMillis();
			SimpleDateFormat dayTime = new SimpleDateFormat("yyMMddHHmmssSSS"); 
			String strDT = dayTime.format(new Date(userNo));
			logger.debug("> result success");
			logger.debug("> ID = " + userVo.getUserId());
			logger.debug("> PW = " + userVo.getUserPw().length());
			logger.debug("> E-MAIL = " + userVo.getUserEmail());
			
			model.addAttribute("result", "S");
		}else {
			logger.debug("> result fails");
			model.addAttribute("result", "F");
			try {
				res.sendRedirect("/login.cpp");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return "login/login";
	}

	@RequestMapping(value = "/join.cpp")
	public String joinView() {
		return "login/join";
	}

	@RequestMapping(value = "/findPw.cpp")
	public String findPwView() {
		return "login/findPw";
	}
}
