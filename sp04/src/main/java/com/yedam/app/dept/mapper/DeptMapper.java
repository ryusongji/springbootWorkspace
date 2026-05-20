package com.yedam.app.dept.mapper;

import java.util.List;

public interface DeptMapper {
	// 조건 없는 다건 조회
	public List<DeptVO> selectDeptAll();
	// 결과가 하나인 단건 조회
	public DeptVO selectDept(DeptVO dept);
	// 등록
	// 결과값을 int로 받음
	// 매개변수는 여러 값이기때문에 객체
	public int insertDept(DeptVO dept);
	// 수정
	// 결과값을 int로 받음
	// 매개변수는 여러 값이기때문에 객체
	public int updateDept(DeptVO dept);
	
	// 삭제
	// 결과값을 int로 받음
	public int deleteDept(int deptId);
}
