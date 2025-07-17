package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {
	
	String path;
	
	@DataProvider(name="LoginData")
	public String [][] loginDataProvider() throws IOException{
		
			path = System.getProperty("user.dir")+"/src/test/resources/Valid_login_sample.xlsx";
			
			ExcelUtility xlutil = new ExcelUtility(path);
			
			int row = xlutil.getRowCount("Sheet1");
			int cell = xlutil.getCellCount("Sheet1",1);
			
			String [][] xldata = new String [row][cell];
			
			for(int i=1;i<=row;i++) {
				
				for(int c=0;c<cell;c++) {
					
					  xldata[i-1][c] = xlutil.getCellData("Sheet1",i,c);
				}
				
			}
			
			return xldata;
		
	}

}
