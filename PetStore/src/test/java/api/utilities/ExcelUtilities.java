package api.utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtilities {
	 static FileInputStream fis;
	static XSSFWorkbook wb;
	static XSSFSheet sheet;
	static XSSFCell cell;
	static XSSFRow row;
   String path;
	
	public  ExcelUtilities(String path) {
		this.path = path;
	}
	
	public  int getrowcount( String Sheetname) throws IOException {
	try {
		fis = new FileInputStream(path);
		wb = new XSSFWorkbook(fis);
		sheet = wb.getSheet(Sheetname);
		int tRow = sheet.getLastRowNum();
		wb.close();
		return tRow;
	}
	
	catch(Exception e){
		return 0;
		}
	}
	public  int getcellcount( String Sheetname) throws IOException {
		try {
			fis = new FileInputStream(path);
			wb = new XSSFWorkbook(fis);
			sheet = wb.getSheet(Sheetname);
			int  tcell = sheet.getRow(0).getLastCellNum();
			wb.close();
			return tcell;
		}
		
		catch(Exception e){
			return 0;
			}  
		}
	public String getcellValue(  String Sheetname, int rownum , int cellnum) throws IOException {
		try {
			fis = new FileInputStream( path);
			wb = new XSSFWorkbook(fis);
			sheet = wb.getSheet(Sheetname);
			row = sheet.getRow(rownum);
			cell = row.getCell(cellnum);
			DataFormatter formatter = new DataFormatter();
			String data;
			data=formatter.formatCellValue(cell);
			
			return data;
		}
		
		catch(Exception e){
			return "";
			}
		}
	
	
}
