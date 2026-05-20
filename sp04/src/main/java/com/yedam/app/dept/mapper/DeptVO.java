package com.yedam.app.dept.mapper;

import lombok.Data;

@Data
public class DeptVO {
	private Integer departmentId; // PK
	private String departmentName; // NOT NULL
	private int managerId; // FK(employees)
	private int locationId; // FK(locations)
}
