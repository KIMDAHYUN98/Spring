package com.company.yedam.emp.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.company.yedam.HomeController;
//import com.company.yedam.emp.dao.DeptDAO;
//import com.company.yedam.emp.dao.EmpDAO;
import com.company.yedam.emp.dao.EmpVO;
//import com.company.yedam.emp.dao.JobDAO;
import com.company.yedam.emp.service.EmpService;

@Controller // @Component 1. 컨테이너 빈으로 등록, 컨트롤러화
public class EmpController {
	
	Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired EmpService empService; // 인터페이스를 읽어온다.
	
	// 사원 목록
	@RequestMapping("/empList")
	public String empList(Model model) {
		// 이 결과를 request 객체에 담아서 보내고 싶을 땐?
		model.addAttribute("list", empService.empList());
		return "emp/empList";
		
	}
	
	// 등록 폼
	@GetMapping("/empInsert")
	public String InsertForm(Model model) {
		//request.setAttribute("deptList", deptDAO.selectList());
		//request.setAttribute("jobList", jobDAO.selectList());
		
		return "emp/empInsert";
	}
	
	// 등록 처리
	@PostMapping("/empInsert")
	public String empInsert(EmpVO vo) {
		// getparameter 할 필요 X, 메소드에 필요한 객체만 넣으면 자동으로 작업
		logger.debug(vo.toString());
		empService.empInsert(vo);;
		return "redirect:empList"; // "emp/empInsert" = forward
	}
	// 수정 폼
	@GetMapping("/empUpdate")
	public String empUpdate(EmpVO vo, Model model) {
		model.addAttribute("empVO", empService.selectOne(vo)); // 단건 조회(return 값)
		//request.setAttribute("deptList", deptDAO.selectList());
		//request.setAttribute("jobList", jobDAO.selectList());
		return "emp/empInsert";
		
		// 앞으로는 getParameter X, vo 만 적어둬도 파라미터 값이 담긴다. 결과값은 model에 담아서 뷰페이지로 이동
		}
	// 수정 처리
	@PostMapping("/empUpdate")
	public String empUpdatePro(EmpVO vo) {
		logger.debug(vo.toString());
		empService.empUpdate(vo);
		return "redirect:empList";
		
	}
	// 이메일 체크
	
	// 사원 검색 기능
	@RequestMapping("/empSearch")
	public String empSearch(EmpVO vo, Model model) {
		model.addAttribute("list", empService.empList());
		return "emp/empSearch";
	}
}
