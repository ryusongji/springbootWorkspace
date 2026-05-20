package com.yedam.app;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.yedam.app.dept.mapper.DeptMapper;
import com.yedam.app.dept.mapper.DeptVO;
import com.yedam.app.emp.service.EmpVO;

@SpringBootTest
@Transactional // 모든 테스트를 자동롤백처리
class Sp04ApplicationTests {
//	@Autowired
//	private EmpMapper empMap;
//	@Test
//	void selectAll() {
//		List<EmpVO> list = empMap.selectEmpAll();
//		assertTrue(!list.isEmpty());
//	}
//	@Test
//	void selectInfo() {
//		EmpVO emp = new EmpVO();
//		emp.setEmployeeId(100);
//		
//		EmpVO findVO = empMap.selectEmp(emp);
//		//           예상결과, 실제결과
//		assertEquals("King", findVO.getLastName());
//	}
//	
//	@Test
//	void insertOne() {
//		EmpVO empVO = new EmpVO();
//		empVO.setLastName("Hong");
//		empVO.setEmail("kdHong@google.com");
//		empVO.setSalary(1000);
//		empVO.setJobId("IT_PROG");
//		// 동적 쿼리 테스트
//		empVO.setHireDate(new Date());
//		
//		int result = empMap.insertEmp(empVO);
//		assertEquals(1,result);
//		assertEquals(207, empVO.getEmployeeId());
//	}
//	
//	@Test
//	void updateOne() {
//		// 1) 단건조회
//		EmpVO emp = new EmpVO();
//		emp.setEmployeeId(206);
//		EmpVO findVO = empMap.selectEmp(emp);
//		
//		// 2) 수정정보 포함
//
//		findVO.setLastName("Adward");
//		findVO.setSalary(8900);
//		
//		// 3) DB 업데이트
//		int result = empMap.updateEmp(findVO);
//		assertEquals(1,result);
//	}
//	
//	@Test
//	void deleteOne() {
//		int result = empMap.deleteEmp(206);
//		assertEquals(1,result);
//	}
//	
//	@Test
//	void search() {
//		EmpVO search = new EmpVO();
//		search.setJobId("IT");
//		search.setManagerId(200);
//		List<EmpVO> result = empMap.selectList(search);
//		System.out.println("job_id와 manager_id ==");
//		result.stream()
//			  .forEach(System.out::println);
//		search = new EmpVO();
//		search.setJobId("SA");
//		result = empMap.selectList(search);
//		System.out.println("job_id만==");
//		result.stream()
//			  .forEach(System.out::println);
//		
//		search = new EmpVO();
//		search.setManagerId(124);
//		result = empMap.selectList(search);
//		System.out.println("manager_id만==");
//		result.stream()
//			  .forEach(System.out::println);
//		
//		result = empMap.selectList(new EmpVO());
//		System.out.println("조건이 없는 경우");
//		result.stream()
//			  .forEach(System.out::println);
//	}
//	
//	@Test
//	void searchByDepts() {
//		List<Integer> deptList = List.of(10,30,50);
//		List<EmpVO> findList = empMap.selectListByDept(deptList);
//		findList.stream()
//			    .forEach(System.out::println);
//	}
//	
	@Autowired
	private DeptMapper deptMap;
	@Test
	void selectAll() {
		List<DeptVO> list = deptMap.selectDeptAll();
		assertTrue(!list.isEmpty());
	}
	@Test
	void selectInfo() {
		DeptVO dept = new DeptVO();
		dept.setDepartmentId(980);
		
		DeptVO findVO = deptMap.selectDept(dept);
		//           예상결과, 실제결과
		assertEquals("Education", findVO.getDepartmentName());
	}
	
	@Test
	void insertOne() {
		DeptVO deptVO = new DeptVO();
		deptVO.setDepartmentName("DepartmentTest");
		deptVO.setManagerId(100);
		deptVO.setLocationId(1800);
		// 동적 쿼리 테스트
		int result = deptMap.insertDept(deptVO);
		assertEquals(1,result);
		assertEquals(981, deptVO.getDepartmentId());
	}
	
	@Test
	void updateOne() {
		// 1) 단건조회
		DeptVO deptVO = new DeptVO();
		deptVO.setDepartmentId(350);
		DeptVO findVO = deptMap.selectDept(deptVO);
		
		// 2) 수정정보 포함

		findVO.setDepartmentName("NameTest");
		
		// 3) DB 업데이트
		int result = deptMap.updateDept(findVO);
		assertEquals(1,result);
	}
	
	@Test
	void deleteOne() {
		int result = deptMap.deleteDept(350);
		assertEquals(1,result);
	}
}
