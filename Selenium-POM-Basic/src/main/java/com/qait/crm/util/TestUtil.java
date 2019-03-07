package com.qait.crm.util;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.qait.crm.base.TestBase;

public class TestUtil extends TestBase{
	public TestUtil() throws IOException {
		super();
	}
	static Workbook wb;
	static Sheet sheet;
	public static long PAGE_LOAD_TIMEOUT = 20;
	public static long IMPLICIT_WAIT = 10;
	
	public void switchToFrame() {
		driver.switchTo().frame("mainpanel");
	}
	public Object[][] getTestData(String sheetname){
		FileInputStream fis = null;
		try {
			fis = new FileInputStream("/home/qainfotech/Desktop/Contacts.xlsx");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		try {
			wb = WorkbookFactory.create(fis);
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		catch(InvalidFormatException e) {
			e.printStackTrace();
		}
		sheet = wb.getSheet(sheetname);
		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		for(int i = 0 ; i < sheet.getLastRowNum() ; i++) {
			for(int k = 0 ; i < sheet.getRow(0).getLastCellNum() ; i++) {
				data[i][k] = sheet.getRow(i+1).getCell(k).toString();
			}
		}
		return data;
	}
}
