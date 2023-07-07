package Practice;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.*;

public class ReadExcel {
	public static void main(String[] args) throws IOException {
		String excelPath = "C:\\Users\\faiza\\eclipse-workspace\\AdvSelenium\\src\\test\\resources\\Excel1.xlsx";
		FileInputStream inputStream = new FileInputStream(excelPath);
		
		XSSFWorkbook wb = new XSSFWorkbook(inputStream);
		XSSFSheet sheet = wb.getSheetAt(0);
		
		int rowCount = sheet.getLastRowNum();
		int colCount = sheet.getRow(1).getLastCellNum();
		System.out.println(rowCount);
		System.out.println(colCount);
		
		for (int i=0; i<=rowCount; i++) {
			XSSFRow row = sheet.getRow(i);
			for (int j=0; j<colCount; j++) {
				XSSFCell cell = row.getCell(j);
				System.out.println(cell);
			}
		}
	}
}
