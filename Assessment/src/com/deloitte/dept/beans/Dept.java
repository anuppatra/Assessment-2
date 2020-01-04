package com.deloitte.dept.beans;

public class Dept {
	private int deptno;
	private String dname;
	private String loc;

	public Dept(int deptno, String dname, String loc) {
		// TODO Auto-generated constructor stub
		this.deptno=deptno;
		this.dname=dname;
		this.loc=loc;
	}
	

	public String getDname() {
		return dname;
	}

	public void setDname(String dname) {
		this.dname = dname;
	}

	public int getDeptno() {
		return deptno;
	}

	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}

	public String getLoc() {
		return loc;
	}

	public void setLoc(String loc) {
		this.loc = loc;
	}

}
