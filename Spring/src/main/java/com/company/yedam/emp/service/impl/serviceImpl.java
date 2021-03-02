package com.company.yedam.emp.service.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.yedam.emp.dao.EmpDAO;
import com.company.yedam.emp.dao.EmpVO;
import com.company.yedam.emp.service.EmpService;
@Service //@Component : 서비스는 컴포넌트를 상속받음, 컨테이너에 빈 등록 및 예외 처리
public class serviceImpl implements EmpService {

	@Autowired
	EmpDAO empDAO;

	@Override
	public void empInsert(EmpVO vo) {
		empDAO.insert(vo);

	}

	@Override
	public void empUpdate(EmpVO vo) {
		empDAO.update(vo);

	}

	@Override
	public void empDelete(EmpVO vo) {

	}

	@Override
	public EmpVO empSearch(EmpVO vo) {
		return empDAO.selectOne(vo.getEmployee_id());

	}

	@Override
	public ArrayList<EmpVO> empList() {
		
		return empDAO.selectList();

	}

	@Override
	public EmpVO selectOne(EmpVO vo) {
		// TODO Auto-generated method stub
		return empDAO.selectOne(vo.getEmployee_id());
	}

}
