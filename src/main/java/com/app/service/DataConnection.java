package com.app.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataConnection {

	public Connection getConnection(){
		Connection connection = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost/restdb","root","1234");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return connection;
	}
	
}
