package com.control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.adminDao;
import com.io.login;

/**
 * Servlet implementation class adminServlet
 */
public class adminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public adminServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		login data = new login(Integer.parseInt(request.getParameter("username")), request.getParameter("password"), "admin");
		if(adminDao.validateAdmin(data)) {
			System.out.println("valid Admin");
			response.sendRedirect("admin.jsp");
		}
		else {
			System.out.println("Invalid User");
			//request.setAttribute("message", "true");
		    response.sendRedirect("login.jsp");
//			 response.sendRedirect("login.jsp?invalid=true");
		}
	}
	
	

}
