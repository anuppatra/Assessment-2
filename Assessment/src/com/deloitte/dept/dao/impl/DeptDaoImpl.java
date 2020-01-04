package com.deloitte.dept.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.deloitee.dept.dao.DeptDao;
import com.deloitte.dept.beans.Dept;
import com.deloitte.dept.utils.DeptUtils;
import oracle.jdbc.OracleDriver;



public class DeptDaoImpl implements DeptDao {
	private Connection conn=null;
	private PreparedStatement pst;
	private ResultSet rs;

	@Override
	public void openConnection() {
		// TODO Auto-generated method stub
		try {
			DriverManager.registerDriver(new OracleDriver());
			String url ="jdbc:oracle:thin:@localhost:1521:orcl";
			String user = "scott";
			String pass = "tiger";
			conn = DriverManager.getConnection(url, user, pass);
		} catch (SQLException e) {
		e.printStackTrace();
		}
	}

	@Override
	public void close() {
		// TODO Auto-generated method stub
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public int addDept(Dept dept) {
		// TODO Auto-generated method stub
		openConnection();
		int rows=0;
		try {
			pst = conn.prepareStatement(DeptUtils.insertqry);
			pst.setInt(1, dept.getDeptno());
			pst.setString(2, dept.getDname());
			pst.setString(3, dept.getLoc());
			rows= pst.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally{
			close();
		}
		return rows;
	}

	
	@Override
	public int deleteDept(int deptno) {
		// TODO Auto-generated method stub
		openConnection();
		int rows=0;
		try {
			pst = conn.prepareStatement(DeptUtils.deleteqry);
			pst.setInt(1, deptno); 
			
			rows=pst.executeUpdate();
	
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		close();
		return rows;
	}

	@Override
	public List<Dept> getDepts() {
		// TODO Auto-generated method stub
		openConnection();
		List<Dept> emplist = new ArrayList<Dept>();
		try {
			pst = conn.prepareStatement(DeptUtils.GETDEPTS);
			rs = pst.executeQuery();
			while(rs.next()){
				Dept dept = new Dept(rs.getInt(1), rs.getString(2),
					rs.getString(3));
				emplist.add(dept);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		close();
		return emplist;
	}

}
