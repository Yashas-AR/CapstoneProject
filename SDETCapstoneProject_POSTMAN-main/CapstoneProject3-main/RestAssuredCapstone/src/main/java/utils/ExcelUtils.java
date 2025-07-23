
package utils;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;

import org.testng.annotations.DataProvider;

public class ExcelUtils {
    private static final String FILE_PATH = System.getProperty("user.dir")+"\\src\\test\\java\\testdata\\CapstoneAPITestingData.xlsx";
    		//"C:\\Users\\Shiva\\Downloads\\CapstoneAPITestingData.xlsx";

    @DataProvider(name="excelData1")
	 public Object[][] getSheet1Data(){
		 Object[][] obj=getExcelData(FILE_PATH,"Sheet1");
		 return obj;
	    }

    @DataProvider(name="excelData2")
	 public Object[][] getSheet2Data(){
		 Object[][] obj=getExcelData(FILE_PATH,"Sheet2");
		 return obj;
	    }

    
	public Object[][] getExcelData(String fileName, String sheetName) {
		Object[][] data=null;
		Workbook wb=null;
		try {
			FileInputStream fs=new FileInputStream(fileName);
			wb=new XSSFWorkbook(fs);
			Sheet sh=wb.getSheet(sheetName);
			Row row=sh.getRow(0);
			int noOfRows=sh.getPhysicalNumberOfRows();
			int noOfCols=row.getLastCellNum();
			Cell cell;
			data=new Object[noOfRows-1][noOfCols];
			for(int i=1;i<noOfRows;i++)
			{
				for(int j=0;j<noOfCols;j++)
				{
					row=sh.getRow(i);
					cell=row.getCell(j);
					switch(cell.getCellType())
					{
						case STRING:
							data[i-1][j]=cell.getStringCellValue();
							break;
						case NUMERIC:
							data[i-1][j]=(int)cell.getNumericCellValue();
							break;
						case BLANK:
							data[i-1][j]="";
							break;
						default:
							data[i-1][j]=null;
							break;
							
					}
				}
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return data;
	}
}