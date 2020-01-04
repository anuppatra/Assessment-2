package com.deloitte.dept.utils;

public class DeptUtils {
	public static String insertqry="insert into dept values(?,?,?)";
	public static String deleteqry="delete from dept where deptno=?";
	public static String updateqry="update dept set(?,?,?) where= ?";
	public static final String GETDEPTS = "select * from dept";
}
