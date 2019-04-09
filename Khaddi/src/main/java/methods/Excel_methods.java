package methods;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Random;


import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excel_methods {
	FileInputStream input = null;
	FileOutputStream writeto = null;
	XSSFWorkbook workbook = null;
	XSSFSheet sheet = null;
	XSSFRow row = null;
	XSSFCell cell = null;
	String path = null;

	// Constructor
	public void methods()  throws IOException {
		path = "E:\\dataSet.xlsx";
		input = new FileInputStream(path);
		workbook = new XSSFWorkbook(input);
		sheet = workbook.getSheetAt(0);
	}

	//function for getting total number of rows present
	public int getSheetRows(String sheetName) {
		int index = workbook.getSheetIndex(sheetName);
		sheet = workbook.getSheetAt(index);
		return (sheet.getLastRowNum() + 1);
	}

	// Provide total number of columns in sheet - testcase
	public int getSheetColumns(String sheetName) {
		int index = workbook.getSheetIndex(sheetName);
		sheet = workbook.getSheetAt(index);
		row = sheet.getRow(0);
		return (row.getLastCellNum());
	}


	//Function for reading data from excel sheet
	public String getCellData(String sheetName, String colName, int rowNum) {
		int colNum = -1;
		int index = workbook.getSheetIndex(sheetName);
		sheet = workbook.getSheetAt(index);
		for (int i = 0; i < getSheetColumns(sheetName); i++) {
			row = sheet.getRow(0);
			cell = row.getCell(i);
			if (cell.getStringCellValue().equals(colName)) {
				colNum = cell.getColumnIndex();
				break;
			}
		}
		row = sheet.getRow(rowNum);
		cell = row.getCell(colNum);
		
			return (cell.getStringCellValue());
	}

	//Function for writing the data back into the Excel file
	public void setCellData(String sheetName, int colNum, int rowNum, String str) {
		int index = workbook.getSheetIndex(sheetName);
		sheet = workbook.getSheetAt(index);
		row = sheet.getRow(rowNum);
		cell = row.createCell(colNum); 
		cell.setCellValue(str);

		try {
			writeto = new FileOutputStream(path);
			try {
				workbook.write(writeto);
				writeto.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	public String randomEmail() {
		return Rand_username()+'.'+Rand_username()  +  "@example.com";
	}




	public  String Rand_username() {
		String mystringCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		StringBuilder mystring = new StringBuilder();
		Random rnd = new Random();
		while (mystring.length() < 10) { // length of the random string.
			int index = (int) (rnd.nextFloat() * mystringCHARS.length());
			mystring.append(mystringCHARS.charAt(index));
		}
		String rand_user = mystring.toString();
		return rand_user;

	}

}
