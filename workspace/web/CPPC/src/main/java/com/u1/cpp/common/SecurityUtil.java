package com.u1.cpp.common;

import java.security.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.u1.cpp.login.web.LoginController;
/**
  * @FileName : SecurityUtil.java
  * @Project : CPPC
  * @Date : 2019. 7. 17. 
  * @작성자 : Include
  * @변경이력 :
  * @프로그램 설명 : 보안 유틸
 */
public class SecurityUtil {
	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
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
