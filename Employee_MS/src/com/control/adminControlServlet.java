package com.control;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.adminDao;
import com.io.Compliance;
import com.io.Department;
import com.io.Employee;

/**
 * Servlet implementation class admintControlServlet
 */
public class adminControlServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public adminControlServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int empId = Integer.parseInt(request.getParameter("empId"));
		Employee emp = adminDao.viewEmployeeFromDB(empId);
		
		PrintWriter out = response.getWriter();
		out.println("EmpId - " + emp.getEmpId() +"<br />");
		out.println("First Name - " + emp.getFname() +"<br />");
		out.println("Last Name - " + emp.getLname() +"<br />");
		out.println("DOB - " + emp.getDob().toString() +"<br />");
		out.println("Email - " + emp.getEmail() +"<br />");
		out.println("Department - " + emp.getDepID().getName()+"<br />");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("action").equalsIgnoreCase("delete")) {
			doDelete(request, response);
			return;
		}
		else if(request.getParameter("action").equalsIgnoreCase("update")) {
			doUpdate(request, response);
			return;
		}
		else if(request.getParameter("action").equalsIgnoreCase("view")) {
			doGet(request, response);
			return;
		}
		else if(request.getParameter("action").equalsIgnoreCase("add")) {
			String firstName = request.getParameter("fname");
			String lastName = request.getParameter("lname");
			Date dob = java.sql.Date.valueOf(request.getParameter("dob"));
			String email = request.getParameter("email");
			Department dep = new Department(request.getParameter("dep"));
			
			Employee e1 = new Employee(firstName,lastName, dob, email, dep);
			adminDao.insertEmployeeinDB(e1);
			
			PrintWriter out = response.getWriter();
			out.print("User Successfully Added");
		}
		else if(request.getParameter("action").equalsIgnoreCase("addDep")) {
			String depName = request.getParameter("depName");
			
			Department dep = new Department(depName);
			
			adminDao.insertDepartmentinDB(dep);
			
			PrintWriter out = response.getWriter();
			out.print("Department Successfully Added");
		}
		else if(request.getParameter("action").equalsIgnoreCase("viewDep")) {
			doGetDep(request, response);
			return;
		}
		else if(request.getParameter("action").equalsIgnoreCase("createReg")) {
			String rltype = request.getParameter("rltype");
			String details = request.getParameter("details");
			Date createdate = java.sql.Date.valueOf(request.getParameter("createdate"));
			//String email = request.getParameter("email");
			Department dep = new Department(request.getParameter("dep"));
			
			
			Compliance comp = new Compliance(rltype,details,createdate,dep);
			
			adminDao.insertComplianceinDB(comp);
			
			PrintWriter out = response.getWriter();
			out.print("Regulations Successfully Created");
		}
		else if(request.getParameter("action").equalsIgnoreCase("viewReg")) {
			doGetReg(request, response);
			return;
		}
	}
	
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int empId = Integer.parseInt(request.getParameter("empid"));
		adminDao.deleteEmployeeFromDB(empId);
		PrintWriter out = response.getWriter();
		out.print("User Successfully Deleted");
	}
	
	protected void doUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int empId = Integer.parseInt(request.getParameter("empId"));
		String firstName = request.getParameter("fname");
		String lastName = request.getParameter("lname");
		Date dob = java.sql.Date.valueOf(request.getParameter("dob"));
		String email = request.getParameter("email");
		Department dep = new Department(request.getParameter("dep"));
		
		Employee e1 = new Employee(firstName,lastName, dob, email, dep);
		adminDao.updateEmployeeFromDB(empId, e1);	
		
		PrintWriter out = response.getWriter();
		out.print("User Successfully Updated");
	}

// Department method
	protected void doGetDep(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int depId = Integer.parseInt(request.getParameter("depId"));
		Department dep = adminDao.viewDepartmentFromDB(depId);
		
		PrintWriter out = response.getWriter();
		out.println("Department Id - " + dep.getId() +"<br />");
		out.println("Department Name - " + dep.getName() +"<br />");
		
	}
	
// Regulation Method
	protected void doGetReg(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int compId = Integer.parseInt(request.getParameter("compId"));
		Compliance comp = adminDao.viewComplianceFromDB(compId);
		
		PrintWriter out = response.getWriter();
		out.println("Compliance Id - " + comp.getCompId() +"<br />");
		out.println("RL Type - " + comp.getRlType() +"<br />");
		out.println("Details - " + comp.getDetails() +"<br />");
		out.println("Create Date - " + comp.getCreateDate() +"<br />");
		out.println("Department Name - " + comp.getDept().getName() +"<br />");
		
	}
}
