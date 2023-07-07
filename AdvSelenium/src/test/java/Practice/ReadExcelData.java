package Practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadExcelData {

	public static void main(String[] args) throws Throwable {

		// Step-1: set the path
		FileInputStream fis = new FileInputStream("src/test/resources/Book2.xlsx");
		//step-2:open workbook in read mode
		Workbook book = WorkbookFactory.create(fis);
		//step-3:get the control to the sheet
		Sheet sh = book.getSheet("Sheet1");
		//step-4: get the control on the row
		Row row = sh.getRow(0);
		//step-5: get the control on the cell
		Cell cel = row.getCell(0);
		//step-6: fetch the data from the cell
		String data = cel.getStringCellValue();
		
		System.out.println(data);
		

	}

}
