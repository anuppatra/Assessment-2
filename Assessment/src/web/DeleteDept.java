package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.deloitee.dept.dao.DeptDao;
import com.deloitte.dept.dao.impl.DeptDaoImpl;

/**
 * Servlet implementation class DeleteDept
 */
@WebServlet("/DeleteDept")
public class DeleteDept extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int rows=0;
		PrintWriter out=response.getWriter();
		int deptno = Integer.parseInt(request.getParameter("deptno"));
	
		DeptDao dao =new DeptDaoImpl();
		rows= dao.deleteDept(deptno);
		out.println(rows+" row deleted");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
