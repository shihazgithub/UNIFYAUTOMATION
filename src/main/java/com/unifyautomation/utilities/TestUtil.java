package com.unifyautomation.utilities;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import com.unifyautomation.base.BaseClass;

public class TestUtil extends BaseClass {

	public static long PAGE_LOAD_TIMEOUT = 20;
	public static long IMPLICIT_WAIT = 100;
	 
	public static String path = System.getProperty("user.dir")+"/src/main/java/com/unifyautomation/testdata/LoginCredentials.xlsx";
    public static Object[][] gettestData(String sheetName) throws IOException
	
	{
		/*
		String loginData[][]= { 
				                {"rmunifyadmin@glowing","Bzea2932","valid"},
				                {"rmunifyadmin@glowing","1234","invalid"}
		};
		*/
		
		
		XLUtility xlutility = new XLUtility(path);
		int rownum = xlutility.getRowCount(sheetName);
		int colnum = xlutility.getCellCount(sheetName, 1);
		
		Object[][] loginData = new Object[rownum][colnum];
		for(int i = 1 ; i <= rownum ; i++ )
		{
			for(int j = 0 ; j <colnum ; j++ )
			{
				loginData[i-1][j] = xlutility.getCellData("Sheet1", i, j);
			}
		}
		
		return loginData;
		
	}
    
    public static void takeScreenshotAtEndOfTest() throws IOException {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String currentDir = System.getProperty("user.dir");
		FileUtils.copyFile(scrFile, new File(currentDir + "/screenshots/" + System.currentTimeMillis() + ".png"));
	}
}
