package com.yedam.app.common.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

// 주의) 모든 클래스는 어떤 형태로든 어노테이션 활용
@Controller // Web(dispatcherServlet)과 관련된 Bean 등록
			// Route = Endpoint(HTTP Method + URL)
//						+ Service
//						+ Return Type(View or Data)
public class URLController {
//	@RequestMapping(path="/getKeyword", method=RequestMethod.GET)
	@GetMapping("/getKeyword")
	@ResponseBody // AJAX
	public String getMapping(String keyword) {
		return "Get Method : keyword, " + keyword;
	}
}
