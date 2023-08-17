package com.ofos.GenericUtility;

import java.io.FileInputStream;
import java.util.Properties;

public class FileUtility
{

	public String getDatafromPropertyFile(String key) throws Throwable
	{
		//create object for file input stream
				FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\Commondata.properties");
				//create object for property class
				Properties pObj = new Properties();
				//load the file 
				pObj.load(fis);
				
				String value = pObj.getProperty(key);
				return value;
				
				
		
		
	}
}
