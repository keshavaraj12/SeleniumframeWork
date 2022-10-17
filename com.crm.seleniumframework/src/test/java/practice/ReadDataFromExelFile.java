package practice;

import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadDataFromExelFile {
public static void main(String[] args) throws Throwable {
	FileInputStream fis = new FileInputStream("C:\\Users\\HP\\Desktop\\Worksheet.xlsx");
	Workbook workbook = WorkbookFactory.create(fis);
	Sheet sheet=workbook.getSheet("sheet1");
	Row row = sheet.getRow(0);
	Cell cell = row.getCell(0);
	String cellsheet = cell.getStringCellValue();
	System.out.println("cellsheet= "+cellsheet);
	workbook.close();
}
}
