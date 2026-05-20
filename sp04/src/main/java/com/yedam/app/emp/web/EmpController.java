package com.yedam.app.emp.web;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yedam.app.emp.service.EmpService;
import com.yedam.app.emp.service.EmpVO;

import lombok.RequiredArgsConstructor;

@Controller // Web(DispatcherServlet)과 관련된 Bean
@RequiredArgsConstructor
public class EmpController {
	
	final private EmpService empService;
	
	// GET : 빈페이지, 조회
	// POST : 데이터 조작 (등록, 수정, 삭제)
	// 삭제 => 경우에 따라 GET로 처리함
	
	// 전체조회 - GET
	@GetMapping("empList") // 1) Endpoint
	public String empList(Model model) {
		// 2) 제공할 서비스
		List<EmpVO> list = empService.findAll();
		// 3) 응답 형태 선택 -  view
		// 3-1) 페이지에 전달할 데이터 담기
		model.addAttribute("emps", list);
		// 3-2) 데이터를 출력할 페이지를 선택
		return "emp/list"; // return은 '/'로 시작하면 안됨
		
	}
	// 단건조회 - GET
	@GetMapping("empInfo") // QueryString 1) 커맨드객체
						   // 커맨드 객체 : @ X, 객체타입
	public String empInfo(EmpVO empVO, Model model) {
		EmpVO findVO = empService.findByEmployeeId(empVO);
		model.addAttribute("emp", findVO);
		return "emp/info";
	}
	// 등록, 페이지 - GET
	@GetMapping("empInsert")
	public String empInsertForm() {
		return "emp/insert";
	}
	// 등록, 처리 - POST => <form/> -> QueryString
	@PostMapping("empInsert")
	public String empInsertProcess(EmpVO empVO) {
		int eid = empService.addEmpInfo(empVO);
		return "redirect:empInfo?employeeId=" + eid;
		// redirect는 새로운 컨트롤러 메소드를 호출
		// 메소드를 만들면 화면에 어떻게 표시되겠구나를 예측
		// 화면설계를 하면 서버는 어떻게 구성이 되겠구나 예측
	}
	
	// 수정, 페이지 - GET => 단건조회 -> QueryString -> 커맨드객체
	@GetMapping("empUpdate")
	public String empUpdateForm(EmpVO empVO, Model model) {
		EmpVO findVO = empService.findByEmployeeId(empVO);
		model.addAttribute("emp", findVO);
		return "emp/update";
	}
	
	// 수정, 처리 - POST => 
	@PostMapping("empUpdate")
	@ResponseBody // AJAX용이라 페이지 없이 데이터만 반환 처리
				  // => 리턴타입이 반환될 데이터를 반영
				  // QueryString이 아니라 JSON으로 받고싶으면 @RequestBody를 넣어야함
	public Map<String, Object> empUpdateProcess(@RequestBody EmpVO empVO){
		return empService.modifyEmpInfo(empVO);
		
	}
	// 삭제, 처리 - GET => QueryString -> 기본타입형 -> @RequestParam
	@GetMapping("empDelete")
	public String empDelete(Integer empId) {
		empService.removeEmpInfo(empId);
		return "redirect:empList";
	}
}
