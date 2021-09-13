package com.qa.testdata;

import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class TestData {
	@DataProvider(name = "Exceldata")
	public String readData(String inputFile, String sheetname, int rowNumber, int columnNumber) throws Exception {
		// create file input stream object for the excel sheet
		FileInputStream fis = new FileInputStream(inputFile);
		// create object for work book
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		// create object for sheet present in excel using Workbook object 'wb'
		XSSFSheet sheet = wb.getSheet(sheetname);
		// create object for row present in sheet using Sheet object 'sheet'
		XSSFRow row = sheet.getRow(rowNumber);
		// create object for cell present in row using Row object 'row'
		XSSFCell cell = row.getCell(columnNumber);
		// return the value present in the excel sheet cell
		return cell.getStringCellValue();
	}

}
