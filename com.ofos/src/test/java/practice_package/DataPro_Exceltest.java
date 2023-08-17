package practice_package;

import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ofos.GenericUtility.Ipathconstants;

public class DataPro_Exceltest 
{
	@Test(dataProvider = "getdatafromExcel")
	public void fetchdata(String client,String Loc,String emp)
	{
		System.out.println("Client----->"+client+"   location-->"+Loc+"   employees---->"+emp);
	}
	

	@DataProvider
	
	public Object[][] getdatafromExcel() throws Throwable
	{
		FileInputStream fi = new FileInputStream(Ipathconstants.Excelpath);
		Workbook wb = WorkbookFactory.create(fi);
		Sheet sh = wb.getSheet("DP");
		int lastrow = sh.getLastRowNum();
		short lastcell = sh.getRow(0).getLastCellNum();
		
		Object[][] obj = new Object[lastrow+1][lastcell];
		for (int i = 0; i <=lastrow; i++) //row
		{
			for (int j = 0; j <lastcell ; j++) //cell
			{
				obj[i][j]=sh.getRow(i).getCell(j).getStringCellValue();
				
			}
			
		}
		return obj;
		
		
	}

}
