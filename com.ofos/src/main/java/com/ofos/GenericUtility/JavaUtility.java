package com.ofos.GenericUtility;

import java.util.Date;
import java.util.Random;
import java.text.SimpleDateFormat;

public class JavaUtility 
{
	
	public int getRandomnum()
	{
		Random ran = new Random();
		int random = ran.nextInt(500);
		return random;
	}
	
	public String getSystem()
	{
		Date d= new Date();
		String date = d.toString();
		return date;
		
	}
	public String getSystemDateInFormat()
	{
		SimpleDateFormat dateformat=new SimpleDateFormat("dd/mm/yyy,hh-MM-ss");
		Date d=new Date();
		  String systemdateinformat = dateformat.format(d);
		  return systemdateinformat;
		
	}
	

}
