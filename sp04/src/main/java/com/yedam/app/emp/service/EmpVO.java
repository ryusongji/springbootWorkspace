package com.yedam.app.emp.service;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class EmpVO {
	// DB와 연결 유무
	private Integer employeeId; // PK
	private String firstName;
	private String lastName; // NOT NULL
	private String email; // NOT NULL, UNIQUE
	private String phoneNumber;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date hireDate; // NOT NULL
	private String jobId; // NOT NULL, FK(jobs)
	private Double salary; // NULL이 아닐경우 1보다 큰 값
	private double commissionPct; // 1보다 작은 수
	private int managerId; // FK(employees)
	private int departmentId; // FK(depaetments)
}
