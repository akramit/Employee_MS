package com.control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.userDao;
import com.io.login;

/**
 * Servlet implementation class userServlet
 */
public class userServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public userServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*Validate the user*/
		
		login data = new login(Integer.parseInt(request.getParameter("username")), request.getParameter("password"), "user");
		if(userDao.validateUser(data)) {
			System.out.println("valid User " + request.getParameter("username"));
			
//			response.sendRedirect("user.jsp");
			
			request.setAttribute("userId", request.getParameter("username"));
			request.getRequestDispatcher("user.jsp").forward(request, response);
		}
		else {
			System.out.println("Invalid User");
			request.setAttribute("message", "Invalid Login");
		    response.sendRedirect("login.jsp");
//			 response.sendRedirect("login.jsp?invalid=true");
			 

		}
	}

}
