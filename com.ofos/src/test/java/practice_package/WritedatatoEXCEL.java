package practice_package;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class WritedatatoEXCEL {

	public static void main(String[] args) throws EncryptedDocumentException, Throwable
	{
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\TESTDATA_ofos.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet("Sheet1");
		Cell cel = sh.createRow(2).createCell(0);
		cel.setCellValue("FOODPANDA");
		FileOutputStream fout = new FileOutputStream(".\\src\\test\\resources\\TESTDATA_ofos.xlsx");
		wb.write(fout);
		fout.flush();
		wb.close();
		
		

	}

}
