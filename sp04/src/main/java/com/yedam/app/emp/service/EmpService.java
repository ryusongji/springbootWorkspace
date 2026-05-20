package com.yedam.app.emp.service;

import java.util.List;
import java.util.Map;

public interface EmpService {
	
	// 사원 전체조회
	public List<EmpVO> findAll();
	
	// 사원 상세조회
	public EmpVO findByEmployeeId(EmpVO empVO);
	// 사원 등록
	public int addEmpInfo(EmpVO empVO);
	// 사원 수정
	public Map<String, Object> modifyEmpInfo(EmpVO empVO);
	// 사원 삭제
	public Map<String, Object> removeEmpInfo(int empId);
}
