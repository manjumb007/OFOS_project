package practice_package;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class Selectquerytest_update {

	public static void main(String[] args) throws SQLException
	{
		Connection con=null;
		int result=0;
		//register the database
		try {
			Driver driver = new Driver();
			DriverManager.registerDriver(driver);
			//get connection for database
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ofos","root","root");
			// create statement
			Statement state = con.createStatement();
			String query = "insert into food_orders values(007,'gobi',50);";
			//update query
			result = state.executeUpdate(query);	
		}
		catch(Exception e)
		{

		}
		finally {
			if(result>0)
			{
				System.out.println("data updated suceesfully");

			}
			else {
				System.out.println("data not inserted");
			}
		}

	}}
