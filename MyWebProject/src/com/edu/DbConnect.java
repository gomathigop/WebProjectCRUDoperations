package com.edu;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbConnect {
	//Connection with database
		static String driver="com.mysql.cj.jdbc.Driver";
		static String url="jdbc:mysql://localhost:3306/SerDb";
		static String un="root";
		static String pswd="rootroot";
		static Connection con;
		
		public static Connection getConnection() {
			try {
				Class.forName(driver);
				con=DriverManager.getConnection(url, un, pswd);
				if(con==null) {
					System.out.println("Connection is null");
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
			return con;
		}
	}


