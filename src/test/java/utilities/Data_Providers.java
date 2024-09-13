package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class Data_Providers {

	@DataProvider(name="Logindata")
	public String[][] getdata() throws IOException
	{

		String path= ".\\testData\\Opencart_LoginData.xlsx";  //path for excel file
		
		ExcelUtility xutil= new ExcelUtility(path);  //object creation for utility
		
		int total_rows= xutil.getRowCount("Sheet1"); //Total number of rows
		int total_cals= xutil.getCellCount("Sheet1", 1); //Total number of columns
		
		String Logindata[][]= new String[total_rows][total_cals]; // Created two dimensional array
		
		for(int i=1; i<=total_rows; i++)
		{
			for(int j=0; j<total_cals; j++)
			{
				Logindata[i-1][j]= xutil.getCellData("Sheet1", i, j); //1,0
			}
		}
		return Logindata; //Returning two dimension array
	}
}
