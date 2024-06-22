package Utilities;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

import org.testng.annotations.Test;

import Constants.constants;
import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;

public class UsingExcelInrestAssured {
	
	
	@Test
	
	public static Map createUser() throws IOException
	{
	
//	String pathCreateUser="D:\\TestData3rdJune.xlsx";
//	String sheetName="Sheet1";
	
	FetchDatafromExcel obj=new FetchDatafromExcel(constants.ExcelPath,constants.sheetName);
	RestAssured.baseURI="https://httpbin.org";
	Map<Object,Object> mp=new LinkedHashMap<Object,Object>();
	mp.put("name", obj.getTestData(1, 0));
	mp.put("gender", obj.getTestData(1, 1));
	mp.put("email",RandomDataSet.generateRandomEmail());
	mp.put("status", obj.getTestData(1, 3));
	return mp;
	
	
	
	
	
	
	}
	
	
	
	

}
