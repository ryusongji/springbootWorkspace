package com.yedam.app.common.web;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.yedam.app.emp.service.EmpService;
import com.yedam.app.emp.service.EmpVO;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class TymeleafController {
	private final EmpService empService;
	
	@GetMapping("thymeleaf")
	public String thymeleaf (Model model) {
		List<EmpVO> list = empService.findAll();
		model.addAttribute("list", list);
		EmpVO empVO = new EmpVO();
		empVO.setEmployeeId(100);
		EmpVO findVO = empService.findByEmployeeId(empVO);
		model.addAttribute("info", findVO);
		return "common";
		// prefix => classpath:/template/
		// suffix => .html
		// 실제 파일의 경로 => prefix + return + suffix
		//				   classpath:/template/common.html
		// 	   classpath = src/main/resources
		// 실제 경로 복사 : /sp04/src/main/resources/templates/common.html
	}
}
