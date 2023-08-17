package practice_package;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import com.mysql.cj.jdbc.Driver;


public class Selectquerytest {

	
	public static void main(String[] args) throws SQLException
	{
		Connection con = null;
		ResultSet result = null;
		try
		//register the database
		{
			Driver driver = new Driver();
			DriverManager.registerDriver(driver);

			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ofos","root","root");


			Statement state = con.createStatement();
			String query = "select * from food_orders;";
			//execute query
			result=state.executeQuery(query);
			while(result.next())
			{
				System.out.println(result.getString(1)+" "+result.getString(2)+" "+result.getShort(3));

			}

		}
		catch(Exception e)
		{

		}
		finally
		{

//close db connection
con.close();



		}
		


	}

}
