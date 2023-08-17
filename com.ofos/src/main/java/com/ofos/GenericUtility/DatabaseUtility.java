
package com.ofos.GenericUtility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.jdbc.Driver;

public class DatabaseUtility 
{
	Connection con =null;
	public void connectToDb() throws SQLException
	{
		
		Driver driver = new Driver();
		DriverManager.registerDriver(driver);
		con=DriverManager.getConnection(Ipathconstants.dbURL,Ipathconstants.dbUSNAME,Ipathconstants.dbPSWD);	
		
	}
	public String executeQueryandGetData(String query ,int columnno,String Expdata) throws SQLException
	{
		ResultSet result = con.createStatement().executeQuery(query);
		boolean flag= false;
		while(result.next())
		{
			String data = result.getString(columnno);
			if(data.equalsIgnoreCase(Expdata))
			{
				flag=true;
				break;
				
				
			}
			
		}
		if(flag)
		{
			System.out.println("--->data is verified");
			return Expdata;
		}
		else
		{
			System.out.println("---->data is not present");
			return"";
		}
		
	}
	
	
	public void closeDb() throws Throwable
	{
		con.close();
	}
	

}
