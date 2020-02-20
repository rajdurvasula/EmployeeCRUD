package com.example.svc.data;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.sql.DataSource;
import javax.naming.Context;
import javax.naming.InitialContext;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class BasicDAO {
	
	private static final String CLAZZ = BasicDAO.class.getCanonicalName();
	private static final Logger logger = Logger.getLogger(CLAZZ);
	
	private Connection connection;
	private String dbHost;
	private int dbPort;
	private String dbName;
	private String dbUser;
	private String dbPassword;
	
	private static String DB_URL = "jdbc:postgresql://%s:%d/%s";
	
	public BasicDAO(String dbHost, int dbPort, String dbName, String dbUser, String dbPassword) {
		this.dbHost = dbHost;
		this.dbPort = dbPort;
		this.dbName = dbName;
		this.dbUser = dbUser;
		this.dbPassword = dbPassword;
	}

	private void setup() {
		try {
			String dbUrl = String.format(DB_URL, dbHost, dbPort, dbName);
                        //Class.forName("org.postgresql.Driver");
			logger.log(Level.INFO, String.format("DB URL = %s", dbUrl));
			//connection = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
       			Context ctx = new InitialContext();
			DataSource empDS = (DataSource) ctx.lookup("java:comp/env/jdbc/EmpDS");
			connection = empDS.getConnection();

		} catch (Exception e) {
			logger.log(Level.SEVERE, "DB connection failed", e);
		}
	}
	
	public void release() {
		try {
			if (null != connection) {
				connection.close();
				connection = null;
			}
		} catch (Exception e) {
			logger.log(Level.SEVERE, "Failed while closing DB connection", e);
		}
	}
	
	public Connection getConnection() {
		if (null == connection)
			setup();
		return connection;
	}
}
