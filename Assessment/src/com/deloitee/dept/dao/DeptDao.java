package com.deloitee.dept.dao;

import java.util.List;

import com.deloitte.dept.beans.Dept;

public interface DeptDao {

		void openConnection();
		void close();
		int deleteDept(int deptno);
		List<Dept> getDepts();
		int addDept(Dept dept);
	}


