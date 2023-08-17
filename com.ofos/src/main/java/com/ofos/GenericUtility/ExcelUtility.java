package com.ofos.GenericUtility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Map.Entry;

import org.apache.commons.collections4.map.HashedMap;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ExcelUtility extends JavaUtility{

	public String readDataFromexcel(String sheetname,int rowNo,int CelNo) throws Throwable, Throwable
	{
		FileInputStream fi = new FileInputStream(Ipathconstants.Excelpath);
		Workbook wb = WorkbookFactory.create(fi);
		String value = wb.getSheet(sheetname).getRow(rowNo).getCell(CelNo).getStringCellValue();
		return value;

	}

	public void writeDataintoExcel(String sheetname,int rowNo,int CelNo,String data) throws Throwable
	{
		FileInputStream fi = new FileInputStream(Ipathconstants.Excelpath);
		Workbook wb = WorkbookFactory.create(fi);
		wb.getSheet(sheetname).createRow(rowNo).createCell(CelNo).setCellValue(data);

		FileOutputStream fos = new FileOutputStream(Ipathconstants.Excelpath);
		wb.write(fos);
		wb.close();

	}

	public int getLastRowno(String sheetname) throws Throwable
	{
		FileInputStream fi = new FileInputStream(Ipathconstants.Excelpath);
		Workbook wb = WorkbookFactory.create(fi);
		Sheet sh = wb.getSheet(sheetname);
		int count = sh.getLastRowNum();

		return count;

	}

	public HashedMap<String,String> getMultipleDataFromExcel(String sheetname,int Keycelno,int valueCelNo) throws Throwable
	{
		//fetching data from excel
		FileInputStream fi = new FileInputStream(Ipathconstants.Excelpath);
		Workbook wb = WorkbookFactory.create(fi);
		Sheet sh = wb.getSheet(sheetname);
		int count = sh.getLastRowNum();

		HashedMap<String, String> map = new HashedMap<String, String>();
		JavaUtility jLib = new JavaUtility();
		for(int i=0;i<=count;i++)
		{
			String key = sh.getRow(i).getCell(Keycelno).getStringCellValue();
			String value = sh.getRow(i).getCell(valueCelNo).getStringCellValue();
			map.put(key, value);
		}
		/*for(Entry<String, String> set:map.entrySet())
		{
			driver.findElement(By.name(set.getKey())).sendKeys(set.getValue()+jLib.getRandomnum());
		}
		 */
		return map;
	}

	public Object[][] DPmultiplesetofDat(String Sheetname) throws Throwable
	{

		FileInputStream fi = new FileInputStream(Ipathconstants.Excelpath);
		Workbook wb = WorkbookFactory.create(fi);
		Sheet sh = wb.getSheet(Sheetname);
		int lastrow = sh.getLastRowNum();
		short lastcell = sh.getRow(0).getLastCellNum();
		
		Object[][] obj = new Object[lastrow+1][lastcell];
		for (int i = 0; i <=lastrow; i++) 
		{
			for (int j = 0; j <lastcell ; j++) 
			{
				obj[i][j]=sh.getRow(i).getCell(j).getStringCellValue();
				
			}
			
		}
		return obj;
		
		
		
	}
	
	
	
	
	
	
	
	
	

}


