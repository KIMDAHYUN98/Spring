package com.company.yedam.emp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import org.springframework.stereotype.Component;
@Component
public class JobDAO {
	Connection conn;
	PreparedStatement psmt;
	
	public ArrayList<JobVO> selectList() {
		ArrayList<JobVO> list = new ArrayList<JobVO>();
		JobVO vo = null;
		try {
			conn = JdbcUtil.connect();
			String sql = "select JOB_ID, JOB_TITLE, MIN_SALARY, MAX_SALARY from jobs order by job_id";
			psmt = conn.prepareStatement(sql);
			ResultSet rs = psmt.executeQuery();
			while(rs.next()) {
				vo = new JobVO();
				vo.setJob_id(rs.getString("job_id"));
				vo.setJob_title(rs.getString("job_title"));
				vo.setMin_salary(rs.getInt("min_salary"));
				vo.setMax_salary(rs.getInt("max_salary"));
				
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
