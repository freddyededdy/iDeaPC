package model;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;


import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;

public class DBManager {

	private static DBManager manager=new DBManager();
	private BasicDataSource ds;
	private DBManager(){
		ds = new BasicDataSource();
		ds.setDriverClassName("com.mysql.jdbc.Driver");
		ds.setUrl("jdbc:mysql://localhost:3306/ideapc?useSSL=false");
		ds.setUsername("root");
		ds.setPassword("root");
	}
	
	public Connection getConnection() throws SQLException{
		return ds.getConnection();
	}
	
	public static DBManager getInstance(){
		return manager;
	}
}