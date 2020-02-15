package com.example.svc.servlet;

import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.svc.data.EmployeeDAO;
import com.example.svc.model.Employee;

/**
 * Servlet implementation class ListEmployees
 */
//@WebServlet(name = "/ListEmployees", urlPatterns = {"/list_all"},
//initParams = {
//		@WebInitParam(name="dbHost", value="192.168.1.28"),
//		@WebInitParam(name="dbPort", value="5432"),
//		@WebInitParam(name="dbName", value="sampledb"),
//		@WebInitParam(name="dbUser", value="guest1"),
//		@WebInitParam(name="dbPassword", value="passw0rd")
//})
public class ListEmployees extends HttpServlet {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8659194323709597115L;
	private static final String CLAZZ = ListEmployees.class.getCanonicalName();
	private static final Logger logger = Logger.getLogger(CLAZZ);
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListEmployees() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());
		try {
			String dbHost = getInitParameter("dbHost");
			int dbPort = Integer.parseInt(getInitParameter("dbPort"));
			String dbName = getInitParameter("dbName");
			String dbUser = getInitParameter("dbUser");
			String dbPassword = getInitParameter("dbPassword");			
			EmployeeDAO dao = new EmployeeDAO(dbHost, dbPort, dbName, dbUser, dbPassword);
			List<Employee> empList = dao.findAll();
			request.setAttribute("empList", empList);
			request.getRequestDispatcher("/list_employees.jsp").forward(request, response);
		} catch (Exception e) {
			logger.log(Level.SEVERE, "Error in JDBC operation: ", e);
			request.getRequestDispatcher("/index.html").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
