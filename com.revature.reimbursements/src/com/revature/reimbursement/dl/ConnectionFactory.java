package com.revature.reimbursement.dl;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;

public class ConnectionFactory {
//	This member variable is for lazy loading
//	private static ConnectionFactory connectionFactory;
	
//	For the eager loading ---> you instantiate ConectionFactory as soon program starts up 
	private static final ConnectionFactory connectionFactory = new ConnectionFactory();
	private Properties prop = new Properties();
	private final org.apache.logging.log4j.Logger logger = LogManager.getLogger(this.getClass());
	
//	force load postgresql driver
//	Static member of the class gets loaded into memory at the start of program
//	Static block get run at the start
	
	static {
		try {
			// We want to check whether postgresql driver is there			
			Class.forName("org.postgresql.Driver");
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	
	
//	Singletons are characterized by the private constructor
	private ConnectionFactory() {
		try {
			ClassLoader loader = Thread.currentThread().getContextClassLoader();
			prop.load(loader.getResourceAsStream("db.properties"));
		}catch(IOException e){
			e.printStackTrace();
			logger.error("Can't find db.props file");
		}
	}
	
//	 as well as the getInstance method
	// ---- This is lazy loading -------
	// ---	Because you instantiate the connection factory after calling it.
	public static ConnectionFactory getInstance() {
//		if(connectionFactory==null) connectionFactory = new ConnectionFactory();
		return connectionFactory;
	}
	
	// 	Factories are characterized by some method that contains logic for object creation
	public Connection getConnection() {
		Connection conn = null;
		//	trying to create connection using db creds
		try {
			conn = DriverManager.getConnection(prop.getProperty("url"),
					prop.getProperty("username"),
					prop.getProperty("password"));
		}catch(SQLException e) {
			e.printStackTrace();
			logger.error("Can't get connection");
		}
		return conn;
	}
	
}
			
