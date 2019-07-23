package com.u1.cpp.login.web;

import java.io.IOException;

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

/**
  * @FileName : LoginController.java
  * @Project : CPPC
  * @Date : 2019. 7. 17. 
  * @�ۼ��� : Include
  * @�����̷� :
  * @���α׷� ���� : login ��Ʈ�ѷ�
 */
@Controller
@RequestMapping(value = "/login/*")
public class LoginController {

	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

	/** loginService */
	@Resource(name = "loginService")
	private LoginService service;
	
	/**
	  * @Method Name : loginView
	  * @�ۼ��� : 2019. 7. 20.
	  * @�ۼ��� : Include
	  * @�����̷� : 
	  * @Method ���� : �α��� ȭ���� �����ش�
	  * @return
	  * @throws Exception
	 */
	@RequestMapping(value = "login.cpp")
	public String loginView() throws Exception {
		return "login/login";
	}
	
	/**
	  * @Method Name : loginCheck
	  * @�ۼ��� : 2019. 7. 20.
	  * @�ۼ��� : Include
	  * @�����̷� : 
	  * @Method ���� : �α��� ���� �˻��մϴ�
	  * @param userVo
	  * @param model
	  * @param req
	  * @param res
	  * @return
	  * @throws Exception
	 */
	@RequestMapping(value = "loginCheck.cpp", method=RequestMethod.POST)
	public String loginCheck(UserVO userVo, ModelMap model, HttpServletRequest req, HttpServletResponse res) throws Exception {
		logger.debug("> loginChecking...");
		
		boolean checkStatus = false;
		
		if(userVo != null
			&& userVo.getUserId() != null
			&& userVo.getUserPw() != null
			&& !"".equals(userVo.getUserId())
			&& !"".equals(userVo.getUserPw())) {
			//DB���� ����� �������� Ȯ���ϴ� ���� �߰�
			//��й�ȣ ��ȣȭ
			SecurityUtil sutil = new SecurityUtil();
			userVo.setUserPw(sutil.encryptSHA256(userVo.getUserPw()));
			
			userVo = service.loginCheck(userVo);
			
			if(userVo != null && userVo.getAuthStatus() != null && !"".equals(userVo.getAuthStatus())) {
				checkStatus = true;
				logger.debug("> login Success!");
				logger.debug("> ID = " + userVo.getUserId());
				logger.debug("> NAME = " + userVo.getUserName());
				logger.debug("> E-MAIL = " + userVo.getUserEmail());
				
				//userVo�� ���ǿ� ����ϴ� ���� �߰��� ��.
				model.addAttribute("result", "S");
			}
		}
		
		if(!checkStatus) {
			logger.debug("> result fails");
			model.addAttribute("result", "F");
			model.addAttribute("resultMsg", "����� ������ ���ų� ���ε��� ���� ���̵� �Դϴ�.");
			try {
				res.sendRedirect("/login/login.cpp");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return "login/login";
	}

	/**
	  * @Method Name : joinView
	  * @�ۼ��� : 2019. 7. 20.
	  * @�ۼ��� : Include
	  * @�����̷� : 
	  * @Method ���� : ȸ������ ȭ��
	  * @return
	  * @throws Exception
	 */
	@RequestMapping(value = "join.cpp")
	public String joinView() throws Exception {
		return "login/join";
	}
	
	/**
	  * @Method Name : joinRequest
	  * @�ۼ��� : 2019. 7. 20.
	  * @�ۼ��� : Include
	  * @�����̷� : 
	  * @Method ���� : ȸ������ �Ϸ�� �������� �߼� �� ����� ���� ����
	  * @param userVo
	  * @param model
	  * @param req
	  * @param res
	  * @return
	  * @throws Exception
	 */
	@RequestMapping(value = "joinRequest.cpp")
	public String joinRequest(UserVO userVo, ModelMap model, HttpServletRequest req, HttpServletResponse res) throws Exception {
		//��й�ȣ ��ȣȭ
		SecurityUtil sutil = new SecurityUtil();
		userVo.setUserPw(sutil.encryptSHA256(userVo.getUserPw()));

		//����� ���� ����
		service.createUser(userVo);
		
		try {
			res.sendRedirect("login.cpp");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "login/login";
	}
	
	/**
	  * @Method Name : joinConfirm
	  * @�ۼ��� : 2019. 7. 20.
	  * @�ۼ��� : Include
	  * @�����̷� : 
	  * @Method ���� : �̸��� ���� �Ϸ�� ����� ����ó�� �� �α��� ȭ������ �̵�
	  * @param userVo
	  * @param model
	  * @param req
	  * @param res
	  * @return
	  * @throws Exception
	 */
	@RequestMapping(value = "joinConfirm.cpp")
	public String joinConfirm(UserVO userVo, ModelMap model, HttpServletRequest req, HttpServletResponse res) throws Exception {
		logger.debug("joinConfirm - success");

		service.userConfirm(userVo);
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
	  * @�ۼ��� : 2019. 7. 20.
	  * @�ۼ��� : Include
	  * @�����̷� : 
	  * @Method ���� : ��й�ȣ ã�� ȭ���� �����ش�
	  * @return
	  * @throws Exception
	 */
	@RequestMapping(value = "/findPw.cpp")
	public String findPwView() throws Exception {
		return "login/findPw";
	}
}
