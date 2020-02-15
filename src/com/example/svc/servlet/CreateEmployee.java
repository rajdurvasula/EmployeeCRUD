package com.example.svc.servlet;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.svc.data.EmployeeDAO;
import com.example.svc.model.Employee;

/**
 * Servlet implementation class CreateEmployee
 */
//@WebServlet(name="CreateEmployee", urlPatterns = {"/create_emp"},
//initParams = {
//		@WebInitParam(name="dbHost", value="192.168.1.28"),
//		@WebInitParam(name="dbPort", value="5432"),
//		@WebInitParam(name="dbName", value="sampledb"),
//		@WebInitParam(name="dbUser", value="guest1"),
//		@WebInitParam(name="dbPassword", value="passw0rd")
//})
public class CreateEmployee extends HttpServlet {

       
    /**
	 * 
	 */
	private static final long serialVersionUID = 8742673464005208639L;
	
	private static final String CLAZZ = CreateEmployee.class.getCanonicalName();
	private static final Logger logger = Logger.getLogger(CLAZZ);

	/**
     * @see HttpServlet#HttpServlet()
     */
    public CreateEmployee() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			String dbHost = getInitParameter("dbHost");
			int dbPort = Integer.parseInt(getInitParameter("dbPort"));
			String dbName = getInitParameter("dbName");
			String dbUser = getInitParameter("dbUser");
			String dbPassword = getInitParameter("dbPassword");
			EmployeeDAO dao = new EmployeeDAO(dbHost, dbPort, dbName, dbUser, dbPassword);
			String salutation = request.getParameter("salutation");
			String firstName = request.getParameter("first_name");
			String lastName = request.getParameter("last_name");
			Integer jobId = Integer.parseInt(request.getParameter("job_id"));
			Integer jobLocationId = Integer.parseInt(request.getParameter("job_loc_id"));
			System.out.println("Status = "+request.getParameter("status"));
			Boolean active = Boolean.valueOf(request.getParameter("status"));
			Employee employee = new Employee(salutation, firstName, lastName, jobId, jobLocationId, active);
			System.out.println(employee.toString());
			Employee newEmployee = dao.create(employee);
			request.setAttribute("emp", newEmployee);
			System.out.println(newEmployee.toString());
			request.getRequestDispatcher("/view.jsp").forward(request, response);
		} catch (Exception e) {
			logger.log(Level.SEVERE, "Employee creation failed");
			request.getRequestDispatcher("/create.jsp").forward(request, response);
		}
	}

}
