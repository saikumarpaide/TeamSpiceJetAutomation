package com.qa.testdata;

import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class ExcelData {

	public String getCellValue(String xlpath, String Sheet, int r, int c) {
		try
		{
			FileInputStream fis = new FileInputStream(xlpath);
			XSSFWorkbook wb = new XSSFWorkbook(fis);
			XSSFCell cell = wb.getSheet(Sheet).getRow(r).getCell(c);
			return cell.getStringCellValue();
		}
		catch (Exception e)
		{
			return "";
		}

	}

	public int getRowCount(String xlpath, String Sheet){
	
		try

		{
			FileInputStream fis = new FileInputStream(xlpath);
			XSSFWorkbook wb = new XSSFWorkbook(fis);
			return wb.getSheet(Sheet).getLastRowNum();
		}
		catch (Exception e)
		{
			return 0;
		}
	}

}