package api.utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class dataproviders {
		@DataProvider(name="Data")
	public String[][] getalldata() throws IOException {
		String path = System.getProperty("user.dir")+"\\testdata\\exceldata.xlsx";
		ExcelUtilities XLuti= new ExcelUtilities(path);
		int rownum = XLuti.getrowcount("Sheet1");
		int colnum = XLuti.getcellcount("Sheet1");
		String data[][]= new String[rownum][colnum];
		for(int i = 1; i<=rownum; i++) {
			for (int j=0; j<colnum;j++) {
				data[i-1][j]=XLuti.getcellValue("Sheet1", i, j);
				//System.out.println(data[i-1][j]);
			}
		}
		
		return data;
	}
		
		
		@DataProvider(name="usernames")
		public String[] getusernames() throws IOException {
			String path = System.getProperty("user.dir")+"\\testdata\\exceldata.xlsx";
			ExcelUtilities XLuti= new ExcelUtilities(path);
			int rownum = XLuti.getrowcount("Sheet1");
			String data[]= new String[rownum];
			for(int i=1;i<=rownum;i++) {
				data[i-1]=XLuti.getcellValue("Sheet1", i, 1);
			}
			return data;
		}
}
