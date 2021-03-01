package com.company.yedam.emp.dao;

import lombok.Data;

@Data
public class DeptVO {
	private int department_id;
	private String department_name;
	private int manager_id;
	private int location_id;
}
