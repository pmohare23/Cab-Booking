package com;

import java.sql.Connection;
import java.sql.DriverManager;

public class Connector {
	
	public static Connection con;
	public static void getConnection()
	{
		try{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection ("jdbc:mysql://localhost/cab","root","asdf");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
