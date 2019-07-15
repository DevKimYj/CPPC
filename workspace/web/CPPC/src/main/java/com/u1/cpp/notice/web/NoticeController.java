package com.u1.cpp.notice.web;

import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
  * @FileName : NoticeController.java
  * @Project : CPPC
  * @Date : 2019. 7. 14. 
  * @�ۼ��� : Include
  * @�����̷� :
  * @���α׷� ���� : mainȭ�� ��Ʈ�ѷ�
 */
@Controller
public class NoticeController {
	
	private static final Logger logger = LoggerFactory.getLogger(NoticeController.class);
	
	/**
	  * @Method Name : main
	  * @�ۼ��� : 2019. 7. 14.
	  * @�ۼ��� : Include
	  * @�����̷� : 
	  * @Method ���� : �Խ��� ȭ���� �����ݴϴ�.
	  * @param locale
	  * @param model
	  * @return
	 */
	@RequestMapping(value = "/notice.cpp")
	public String noticeView(Model model) {
		logger.debug("call /notice.cpp");
		return "notice/notice";
	}
}
