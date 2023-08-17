package practice_package;

import java.io.FileInputStream;
import java.util.Properties;

public class REAddatafromProp {

	public static void main(String[] args) throws Throwable
	{
		//create object for file input stream
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\Commondata.properties");
		//create object for property class
		Properties pObj = new Properties();
		//load the file 
		pObj.load(fis);

		//get the value using key
		String URL = pObj.getProperty("url");
		String BROWSER = pObj.getProperty("browser");
		String PASSWORD = pObj.getProperty("password");
		System.out.println(URL);
		System.out.println(BROWSER);
		System.out.println(PASSWORD);



	}

}
