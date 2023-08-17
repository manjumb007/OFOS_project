package practice_package;

import java.io.FileInputStream;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class REaddatafromEXCEL {

	public static void main(String[] args) throws EncryptedDocumentException, Throwable 
	{
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\TESTDATA_ofos.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet("Sheet1");
		Row ro = sh.getRow(1);
		Cell cel = ro.getCell(0);
		String value = cel.getStringCellValue();
		System.out.println(value);
		wb.close();

	}

}
