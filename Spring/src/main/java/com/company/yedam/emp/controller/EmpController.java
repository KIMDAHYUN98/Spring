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
import com.company.yedam.emp.dao.EmpDAO;
import com.company.yedam.emp.dao.EmpVO;
import com.company.yedam.emp.dao.JobDAO;

@Controller
public class EmpController {
	
	Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired EmpDAO empDAO;
	@Autowired DeptDAO deptDAO;
	@Autowired JobDAO jobDAO;
	
	// 사원 목록
	@RequestMapping("/empList")
	public String empList(HttpServletRequest request) {
		// 이 결과를 request 객체에 담아서 보내고 싶을 땐?
		request.setAttribute("list", empDAO.selectList());
		return "emp/empList";
		
	}
	
	// 등록 폼
	@GetMapping("/empInsert")
	public String InsertForm(HttpServletRequest request) {
		request.setAttribute("deptList", deptDAO.selectList());
		request.setAttribute("jobList", jobDAO.selectList());
		
		return "emp/empInsert";
		}
	
	// 등록 처리
	@PostMapping("/empInsert")
	public String empInsert(EmpVO vo) {
		// getparameter 할 필요 X, 메소드에 필요한 객체만 넣으면 자동으로 작업
		logger.debug(vo.toString());
		empDAO.insert(vo);
		return "redirect:empList"; // "emp/empInsert" = forward
	}
	// 수정 폼
	@GetMapping("/empUpdate")
	public String empUpdate(HttpServletRequest request) {
		String empid = request.getParameter("employee_id");
		request.setAttribute("empVO", empDAO.selectOne(empid));
		request.setAttribute("deptList", deptDAO.selectList());
		request.setAttribute("jobList", jobDAO.selectList());
		return "emp/empInsert";
		}
	// 수정 처리
	@PostMapping("/empUpdate")
	public String empUpdatePro(EmpVO vo) {
		logger.debug(vo.toString());
		empDAO.update(vo);
		return "redirect:empList";
		
	}
	// 이메일 체크
	
	// 사원 검색 기능
	@RequestMapping("/empSearch")
	public String empSearch(HttpServletRequest request) {
		request.setAttribute("list", empDAO.selectList());
		return "emp/empSearch";
	}
}
