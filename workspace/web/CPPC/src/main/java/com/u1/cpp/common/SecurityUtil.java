package com.u1.cpp.common;

import java.security.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.u1.cpp.login.service.UserVO;

/**
  * @FileName : SecurityUtil.java
  * @Project : CPPC
  * @Date : 2019. 7. 17. 
  * @작성자 : Include
  * @변경이력 :
  * @프로그램 설명 : 보안 유틸
 */
public class SecurityUtil extends HandlerInterceptorAdapter {
	private static final Logger logger = LoggerFactory.getLogger(SecurityUtil.class);
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		// Controller 호출 전
		logger.debug("request url -> " + request.getRequestURL().toString());

		HttpSession session = request.getSession();
		
		if(session != null) {
			UserVO userVo = (UserVO)session.getAttribute("userVo");
			
			if(userVo != null && userVo.getUserNo() != null && "".equals(userVo.getUserNo())) {
				logger.debug("session ID -> " + userVo.getUserNo());
				return true;
			}else {
				logger.debug("session Info -> 사용자 정보가 없습니다.");
				response.sendRedirect("/login/login.cpp");
				return false;
			}
		}else {
			logger.debug("session Info -> 세션이 만료되었습니다.");
			response.sendRedirect("/login/login.cpp");
			return false;
		}
	}
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
		// Controller 호출 후
		super.postHandle(request, response, handler, modelAndView);
	}
	
	public String encryptSHA256(String str) {
		String sha = "";
		try {
			MessageDigest sh = MessageDigest.getInstance("SHA-256");
			sh.update(str.getBytes());
			byte byteData[] = sh.digest();
			StringBuffer sb = new StringBuffer();
			for(int i = 0; i < byteData.length; i++) {
				sb.append(Integer.toString((byteData[i]&0xff) + 0x100, 16).substring(1));
			}
			sha = sb.toString();
		}catch(NoSuchAlgorithmException e) {
			logger.debug("Encrypt Error - NoSuchAlgorithmException");
			sha = null;
		}
		return sha;
	}
}
