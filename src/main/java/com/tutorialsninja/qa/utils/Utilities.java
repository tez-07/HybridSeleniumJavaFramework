package com.tutorialsninja.qa.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Utilities {

	public static String generateEmailWithTimestamp() {
		Date date = new Date();
		String timeStamp = date.toString().replace(" ", "_").replace(":", "_");
		
		return "amotori"+timeStamp+"@gmail.com";
	}
	
	
	//method to retrieve the test data from excel sheet
	public static Object[][] getTestDataFromExcel(String sheetName) {	
		
		File excelFile = new File(System.getProperty("user.dir")+"\\src\\main\\java\\com\\tutorialsninja\\qa\\testdata\\TutorialsNinjaTestData.xlsx");
		XSSFWorkbook workbook = null;

		//try catch required as if the excel sheet is not found error should be handled
		try {
			FileInputStream excelFile1 = new FileInputStream(excelFile);		
			workbook = new XSSFWorkbook(excelFile1);
		}catch(Throwable e) {
			e.printStackTrace();
		}
		
		XSSFSheet sheet = workbook.getSheet(sheetName);		
		int rows = sheet.getLastRowNum();
		int cols = sheet.getRow(0).getLastCellNum();
		
		Object data[][] = new Object[rows][cols];
		
		for(int i=0;i<rows;i++) {
			
			XSSFRow row = sheet.getRow(i+1);			
			for(int j=0;j<cols;j++) {
				
				XSSFCell cell = row.getCell(j);
				CellType cellType = cell.getCellType();			//CellType is used to get the type of cell whether it is an integer or string
				
				switch(cellType) {
					
				case STRING:
					data[i][j] = cell.getStringCellValue();
					break;
				case NUMERIC:
					data[i][j] = Integer.toString((int)cell.getNumericCellValue());
					break;
				case BOOLEAN:
					data[i][j] = cell.getStringCellValue();
					break;
				default:
					break;
				}
			}
		}
		return data;
	}
	
	public static String captureScreenshot(WebDriver driver, String testName) {
		
		File srcScreenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String destinationPath = System.getProperty("user.dir"+"\\Screenshots\\"+testName+".png"); 	
		
		try {
			FileHandler.copy(srcScreenshot, new File(destinationPath));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return destinationPath;
	}
}
