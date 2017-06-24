package me.laszloszoboszlai.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class VerifyJDBCConnection {
	public static void main(String[] args) {
		String host = "localhost";
	    String port = "3306";
		String dbName = "hb_student_tracker";
        String options = "?useSSL=false";
		String userName = "hbstudent";
	    String passWord = "hbstudent";	
		String JDBCUrl = "jdbc:mysql://" + host + ":" + port+ "/" + dbName + options;
		
		try {
			System.out.println("Connecting to DB: " + dbName);
			
			Connection dbConn = DriverManager.getConnection(JDBCUrl, userName, passWord);
			
			System.out.println("Connected!");
			
			dbConn.close();
		}
		catch (Exception e){
			System.out.println("Connection error!");
		}
	}
}