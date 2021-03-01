package com.company.yedam.emp.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.company.yedam.HomeController;
import com.company.yedam.emp.dao.DeptDAO;
import com.company.yedam.emp.dao.DeptVO;
import com.company.yedam.emp.dao.EmpDAO;
import com.company.yedam.emp.dao.JobDAO;

@Controller
public class DeptController {
Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired EmpDAO empDAO;
	@Autowired DeptDAO deptDAO;
	@Autowired JobDAO jobDAO;
	
	// 부서 목록
	@RequestMapping("/deptList")
	public String deptList(HttpServletRequest request) {
		request.setAttribute("list", deptDAO.selectList());
		return "emp/deptList";
	}
	
	//부서 등록 폼
	@GetMapping("/deptInsert")
	public String InsertDept(HttpServletRequest request) {
		request.setAttribute("deptList", deptDAO.selectList());
		request.setAttribute("jobList", jobDAO.selectList());
		return "emp/deptInsert";
	}
	
	// 등록 처리
	@PostMapping("/deptInsert")
	public String insertDeptPro(DeptVO vo) {
		logger.debug(vo.toString());
		deptDAO.insert(vo);
		return "redirect:deptList";
	}
	
}
