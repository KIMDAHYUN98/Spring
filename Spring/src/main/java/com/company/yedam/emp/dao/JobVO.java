package com.company.yedam.emp.dao;

import lombok.Data;

@Data
public class JobVO {
	private String job_id;
	private String job_title;
	private int min_salary;
	private int max_salary;
}
