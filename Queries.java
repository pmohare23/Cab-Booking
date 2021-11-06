package com;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import java.sql.Statement;
import java.util.ArrayList;



public class Queries {
	Scanner scan;
	String car,name,source,destination;
	int noofseats,tripid;
	
	
	public Queries()
	{
		   scan = new Scanner(System.in);
		   Connector.getConnection();
		   
	}
	
	public void delete(int tripId) {
		
		String q = "delete from bookings where trip_id=?";
		try
		{
			PreparedStatement pst = Connector.con.prepareStatement(q);
			pst.setInt(1,tripId);
			int res = pst.executeUpdate();
			System.out.println("Deleted Row : " + res);
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		
	}
	
	public void insert(String car,String name,String source,String destination,int noofseats,int tripid)
	{
		try
		{
			String q = "insert into bookings values(?,?,?,?,?,?)";
			PreparedStatement pst = Connector.con.prepareStatement(q);
			pst.setString(1,car);
			pst.setString(2,name);
			pst.setString(3,source);
			pst.setString(4,destination);
			pst.setInt(5,noofseats);
			pst.setInt(6,tripid);
			int i = pst.executeUpdate();
			System.out.println("Rows affected :" +i);
		}
		catch(Exception e)
		{
	    e.printStackTrace();
		}
	}
	
	public String[][] selectAsArray()
	{
		String data[][]=null;
		try
		{
			String q = "select * from Bookings";
			Statement st = Connector.con.createStatement();
			ResultSet rs = st.executeQuery(q);
			int i=0;
			while(rs.next())
				i++;
			data = new String[i][6];
			rs.beforeFirst();
			i=0;
			while(rs.next())
			{
				data[i][0] = rs.getString(1);
				data[i][1] = rs.getString(2);
				data[i][2] = rs.getString(3);
				data[i][3] = rs.getString(4);
				data[i][4] = rs.getString(5);
				data[i][5] = rs.getString(6);
				i++;
			}
		}
		catch(Exception e)
		{
		e.printStackTrace();
	    }
		return data;
			}
			
			
}


