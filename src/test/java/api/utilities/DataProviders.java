package api.utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {
	@DataProvider(name="alldata")
	public String[][] dataprovider_username() throws IOException {
		//will get the current location project and exlfilepathlocation
		String path=System.getProperty("user.dir")+"//TestData//Userdata.xlsx";
		//here we are using xlutility class
		XLUtility xl=new XLUtility(path);
		//getteing all rowcount from exlsheet and cell count
		int rowcount=xl.getRowCount("Sheet1");
		int cellcount=xl.getCellCount("Sheet1", 1);
		//creating 2 dimentional string array
		String apidata[][]=new String[rowcount][cellcount];
		
		for(int i=1;i<=rowcount;i++) 
		{
			for(int j=0;j<cellcount;j++) 
			{
				apidata[i-1][j]=xl.getCellData("Sheet1", i,j);
			}
			
		}
		
		return apidata;
		
	}

	//getting only username from the excel data
	@DataProvider(name="username")
	public String[] dataprovider_alldata() throws IOException 
	{
		//will get the current location project and exlfilepathlocation
		String path=System.getProperty("user.dir")+"//TestData//Userdata.xlsx";
		//here we are using xlutility class
		XLUtility xl=new XLUtility(path);
		//getteing all rowcount from exlsheet and cell count
		int rowcount=xl.getRowCount("Sheet1");
		
		//creating single dimentional string array
		String[] apidata=new String[rowcount];
		
		for(int i=1;i<=rowcount;i++) 
		{
			
				apidata[i-1]=xl.getCellData("Sheet1", i,1);
			}
			
		
		
		return apidata;
		
	
	}	
}
