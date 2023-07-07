package Generic_Utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormat;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Excel_Utility {

	/**
	 * This method is used to Fetch data from excelsheet
	 * 
	 * @param sheetname
	 * @param rowNum
	 * @param cellNum
	 * @return
	 * @throws Throwable
	 */
	public String getExcelData(String sheetname, int rowNum, int cellNum) throws Throwable {
		// Step:1 Set the path
		FileInputStream fis = new FileInputStream("src/test/resources/AaraExcel.xlsx");
		// Step2:Open workbook in read mode
		Workbook book = WorkbookFactory.create(fis);
		System.out.println(sheetname);
		// Step:3 get the control on the sheet
		Sheet sh = book.getSheet(sheetname);
		System.out.println(rowNum);
		// Step:4 get the control on the row
		Row row = sh.getRow(rowNum);
		
//Step:5 get the control on the cell
		Cell cel = row.getCell(cellNum);
		// Step:6 fetch the data from the cell
		String value = cel.getStringCellValue();
		return value;
	}

	/**
	 * This method is used to fetch data from excelsheet using formatter
	 * 
	 * @param SheetName
	 * @param rowNum
	 * @param cellNum
	 * @return
	 * @throws Throwable
	 */
	public String getExcelDataUSingDataFormatter(String SheetName, int rowNum, int cellNum) throws Throwable {
		FileInputStream fis1 = new FileInputStream("src/test/resources/AaraExcel.xlsx");
		Workbook book = WorkbookFactory.create(fis1);
		DataFormatter format = new DataFormatter();
		String value = format.formatCellValue(book.getSheet(SheetName).getRow(rowNum).getCell(cellNum));
		return value;

	}
}