package com.jtest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class Excel {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
	
		String filePath = "/home/pranesh/Documents/Selenium/DDT/book.xls";
		FileInputStream file = new FileInputStream(filePath);
		HSSFWorkbook workbook = new HSSFWorkbook(file);
		HSSFSheet sheet = workbook.getSheetAt(1);
		HSSFRow row;
		row = sheet.getRow(0);
		int colCount = row.getLastCellNum();
		System.out.println("Column Count :- " + colCount);
		int rowCount = sheet.getLastRowNum() + 1;
		System.out.println("Row Count :- " + rowCount);

		
	}

}
