package Utilities;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ReadDataFromPropertyFile {
	
	static FileReader reader;
	
	
	public static Properties readDatafromProperty()
	{
		
		try {
			
			
			reader=new FileReader("src\\main\\java\\PropertyData\\Global.properties");
			
			
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		Properties prop=new Properties();
		
		
		
		
		try {
			
			
			
			prop.load(reader);
			
			
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return prop;
		
		
		
	}

}
