package com.company.yedam.emp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import org.springframework.stereotype.Component;

@Component
public class DeptDAO {
	Connection conn;
	PreparedStatement psmt;
	
	
	// 전체 조회
	public ArrayList<DeptVO> selectList() {
		ArrayList<DeptVO> list = new ArrayList<DeptVO>();
		DeptVO vo = null;
		try {
			conn = JdbcUtil.connect();			
			String sql = "SELECT DEPARTMENT_ID, "
					+ "DEPARTMENT_NAME, "
					+ "MANAGER_ID, "
					+ "LOCATION_ID FROM DEPARTMENTS "
					+ "ORDER BY DEPARTMENT_ID";
			psmt = conn.prepareStatement(sql);
			ResultSet rs = psmt.executeQuery();
			while(rs.next()) {
				vo = new DeptVO();
				vo.setDepartment_id(rs.getInt(1));
				vo.setDepartment_name(rs.getString(2));
				vo.setMANAGER_ID(rs.getInt(3));
				vo.setLOCATION_ID(rs.getInt(4));
				
				list.add(vo);
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.disconnect(conn);
		}
		return list;
	}
}
