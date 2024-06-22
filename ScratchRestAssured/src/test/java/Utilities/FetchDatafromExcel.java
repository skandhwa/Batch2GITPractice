package Utilities;

import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class FetchDatafromExcel {
	
	static XSSFWorkbook workbook;
	static XSSFSheet sheet;
	
	FetchDatafromExcel(String excelPath,String sheetName) throws IOException
	{
		 workbook=new XSSFWorkbook(excelPath);
		 sheet=workbook.getSheet(sheetName);
		int x=sheet.getPhysicalNumberOfRows();
		System.out.println(x);
//	XSSFCell Value=	sheet.getRow(1).getCell(2);
//	System.out.println(Value);
		
	}
	
		public static Object getTestData(int rownum,int cellnum)
		
		
		{
		
		DataFormatter formatter=new DataFormatter();
		
	Object value=	formatter.formatCellValue(sheet.getRow(rownum).getCell(cellnum));
	
	
	return value;
	
		}
		
		
		
		
	}
	
	
	
	


