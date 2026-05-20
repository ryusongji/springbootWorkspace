package com.yedam.app.emp.mapper;

import java.util.List;

import com.yedam.app.emp.service.EmpVO;

public interface EmpMapper {
	// 조건 없는 다건 조회
	public List<EmpVO> selectEmpAll();
	// 결과가 하나인 단건 조회
	public EmpVO selectEmp(EmpVO emp);
	// 등록
	public int insertEmp(EmpVO emp);
	// 수정
	public int updateEmp(EmpVO emp);
	// 삭제
	public int deleteEmp(int empId);
	// 경우에 따라 조건이 존재하는 다건 조회
	public List<EmpVO> selectList(EmpVO emp);
	public List<EmpVO> selectListByDept(List<Integer> depts);
}
