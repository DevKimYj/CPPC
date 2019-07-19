package com.u1.cpp.login.web;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.u1.cpp.common.SecurityUtil;
import com.u1.cpp.login.service.LoginService;
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

	/** loginService */
	@Resource(name = "loginService")
	private LoginService service;
	
	/**
	  * @Method Name : loginView
	  * @작성일 : 2019. 7. 20.
	  * @작성자 : Include
	  * @변경이력 : 
	  * @Method 설명 : 로그인 화면을 보여준다
	  * @return
	  * @throws Exception
	 */
	@RequestMapping(value = "/login/login.cpp")
	public String loginView() throws Exception {
		return "login/login";
	}
	
	/**
	  * @Method Name : loginCheck
	  * @작성일 : 2019. 7. 20.
	  * @작성자 : Include
	  * @변경이력 : 
	  * @Method 설명 : 로그인 정보 검사합니다
	  * @param userVo
	  * @param model
	  * @param req
	  * @param res
	  * @return
	  * @throws Exception
	 */
	@RequestMapping(value = "/login/loginCheck.cpp", method=RequestMethod.POST)
	public String loginCheck(UserVO userVo, ModelMap model, HttpServletRequest req, HttpServletResponse res) throws Exception {
		logger.debug("> loginCheck...");
		if(userVo != null
			&& userVo.getUserId() != null
			&& userVo.getUserPw() != null
			&& !"".equals(userVo.getUserId())
			&& !"".equals(userVo.getUserPw())) {
			//DB에서 사용자 인증여부 확인하는 로직 추가
			
			userVo = service.loginCheck(userVo);
			
			logger.debug("> result success");
			logger.debug("> ID = " + userVo.getUserId());
			logger.debug("> PW = " + userVo.getUserPw().length());
			logger.debug("> E-MAIL = " + userVo.getUserEmail());
			
			model.addAttribute("result", "S");
		}else {
			logger.debug("> result fails");
			model.addAttribute("result", "F");
			try {
				res.sendRedirect("/login/login.cpp");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return "login/login";
	}

	/**
	  * @Method Name : joinView
	  * @작성일 : 2019. 7. 20.
	  * @작성자 : Include
	  * @변경이력 : 
	  * @Method 설명 : 회원가입 화면
	  * @return
	  * @throws Exception
	 */
	@RequestMapping(value = "/login/join.cpp")
	public String joinView() throws Exception {
		return "login/join";
	}
	
	/**
	  * @Method Name : joinRequest
	  * @작성일 : 2019. 7. 20.
	  * @작성자 : Include
	  * @변경이력 : 
	  * @Method 설명 : 회원가입 완료시 인증메일 발송 및 사용자 정보 생성
	  * @param userVo
	  * @param model
	  * @param req
	  * @param res
	  * @return
	  * @throws Exception
	 */
	@RequestMapping(value = "/login/joinRequest.cpp")
	public String joinRequest(UserVO userVo, ModelMap model, HttpServletRequest req, HttpServletResponse res) throws Exception {
		//사용자 정보 생성
		service.createUser(userVo);
		
		try {
			res.sendRedirect("/login/login.cpp");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "login/login";
	}
	
	/**
	  * @Method Name : joinConfirm
	  * @작성일 : 2019. 7. 20.
	  * @작성자 : Include
	  * @변경이력 : 
	  * @Method 설명 : 이메일 인증 완료시 사용자 인증처리 후 로그인 화면으로 이동
	  * @param userVo
	  * @param model
	  * @param req
	  * @param res
	  * @return
	  * @throws Exception
	 */
	@RequestMapping(value = "/login/joinConfirm.cpp")
	public String joinConfirm(UserVO userVo, ModelMap model, HttpServletRequest req, HttpServletResponse res) throws Exception {
		logger.debug("joinConfirm - success");

		try {
			res.sendRedirect("/login/login.cpp");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "login/login";
	}

	/**
	  * @Method Name : findPwView
	  * @작성일 : 2019. 7. 20.
	  * @작성자 : Include
	  * @변경이력 : 
	  * @Method 설명 : 비밀번호 찾기 화면을 보여준다
	  * @return
	  * @throws Exception
	 */
	@RequestMapping(value = "/findPw.cpp")
	public String findPwView() throws Exception {
		return "login/findPw";
	}
}
