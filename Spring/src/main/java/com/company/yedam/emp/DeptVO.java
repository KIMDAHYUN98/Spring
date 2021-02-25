package com.company.yedam.emp;

import lombok.Data;

@Data
public class DeptVO {
	private int department_id;
	private String department_name;
	private int MANAGER_ID;
	private int LOCATION_ID;
}
