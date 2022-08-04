package utilities;

import java.io.FileInputStream;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelRead {
	
//	 URL to get the binary - http://poi.apache.org/download.html
//	 Binary Name - poi-bin-5.2.2-20220312.zip
//	 Extract the binary
//	 Add all the jars from the location you extracted to the build path
//	 Also add all the jars from lib, do not add the jar file of log4j
//	 Also add all the jars from ooxml-lib
//	 Only works for Excel 2007+

	public static void main(String[] args) {
		
		XSSFWorkbook ExcelWBook;
		XSSFSheet ExcelWSheet;
		XSSFCell Cell;
		
		//location of the excel file
		
		String location="C:\\Users\\DELL\\eclipse-workspace\\DataDrivenFramework\\src\\utilities\\ExcelRead.xlsx";
		String sheetName = "test";
		
		try {
			FileInputStream ExcelFile=new FileInputStream(location);
			ExcelWBook=new XSSFWorkbook(ExcelFile);
			ExcelWSheet=ExcelWBook.getSheet(sheetName);
			
			Cell=ExcelWSheet.getRow(1).getCell(2);
			
			String data=Cell.getStringCellValue();
			
			System.out.println("Value of the 1st cell is: "+data);

			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		

	}

}
