package com.example.svc.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.example.svc.model.Employee;

public class EmployeeDAO extends BasicDAO {
	
	private static final String CLAZZ = EmployeeDAO.class.getCanonicalName();
	private static final Logger logger = Logger.getLogger(CLAZZ);

	private static final String CREATE_EMP = "insert into employee(salutation, first_name, last_name, job_id, job_loc_id, status) values (?, ?, ?, ?, ?, ?)";
	private static final String ALL_EMP = "select * from employee";
	
	public EmployeeDAO(String dbHost, int dbPort, String dbName, String dbUser, String dbPassword) {
		super(dbHost, dbPort, dbName, dbUser, dbPassword);
	}
	
	public Employee create(Employee employee) {
		PreparedStatement pstmt = null;
		Connection conn = getConnection(); 
		try {
			if (null != conn) {
				pstmt = conn.prepareStatement(CREATE_EMP, Statement.RETURN_GENERATED_KEYS);
				pstmt.setString(1, employee.getSalutation());
				pstmt.setString(2, employee.getFirstName());
				pstmt.setString(3,  employee.getLastName());
				pstmt.setInt(4,  employee.getJobId());
				pstmt.setInt(5,  employee.getJobLocationId());
				pstmt.setBoolean(6, employee.getActive());
				pstmt.executeUpdate();
				ResultSet rs = pstmt.getGeneratedKeys();
				while (rs.next()) {
					int newId = rs.getInt(1);
					employee.setId(newId);
					logger.log(Level.INFO, String.format("Created Employee with Id: %d", newId));
				}				
			}
		} catch (Exception e) {
			logger.log(Level.SEVERE, "Error in JDBC operation: ", e);
		} finally {
			if (null != pstmt) {
				try {
					pstmt.close();
					pstmt = null;					
				} catch (Exception e1) {
					logger.log(Level.SEVERE, "Error in JDBC statement: ", e1);
				}
			}
			if (null != conn) {
				try {
					conn.close();
					conn = null;
				} catch (Exception e1) {
					logger.log(Level.SEVERE, "Error in JDBC statement: ", e1);
				}
			}
		}
		return employee;
	}
	
	public List<Employee> findAll() {
		PreparedStatement pstmt = null;
		Connection conn = getConnection();
		ArrayList<Employee> empList = new ArrayList<Employee>();
		try {
			pstmt = conn.prepareStatement(ALL_EMP);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				String salutation = rs.getString("salutation");
				String firstName = rs.getString("first_name");
				String lastName = rs.getString("last_name");
				Integer jobId = rs.getInt("job_id");
				Integer jobLocId = rs.getInt("job_loc_id");
				Boolean status = rs.getBoolean("status");
				Employee emp = new Employee(salutation, firstName, lastName, jobId, jobLocId, status);
				emp.setId(rs.getInt("id"));
				empList.add(emp);
			}
		} catch (Exception e) {
			logger.log(Level.SEVERE, "Error in JDBC operation: ", e);
		} finally {
			if (null != pstmt) {
				try {
					pstmt.close();
					pstmt = null;
				} catch (Exception e1) {
					logger.log(Level.SEVERE, "Error in JDBC statement: ", e1);
				}
			}
		}
		return empList;
	}
}
