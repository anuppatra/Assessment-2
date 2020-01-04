package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.deloitee.dept.dao.DeptDao;
import com.deloitte.dept.beans.Dept;
import com.deloitte.dept.dao.impl.DeptDaoImpl;

/**
 * Servlet implementation class GetDepts
 */
@WebServlet("/GetDepts")
public class GetDepts extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		
		
		DeptDao dao = new DeptDaoImpl();
		List<Dept> emplist = dao.getDepts();
		out.println("<table border=3>");
		out.println("<tr><th>DEPARTMENT NO<TH>DEPARTMENT NAME<TH>LOCATION</tr>");
		for(Dept e : emplist){
			out.println("<tr>");
			out.println("<td>"+e.getDeptno()+"</td>");
			out.println("<td>"+e.getDname()+"</td>");
			out.println("<td>"+e.getLoc()+"</td>");
		
		}
		out.println("</table>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
