package Utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtil {

	public static List<Map<String, String>> readexcelDataUsingCollections(String excelFileName, String sheetName) {

		List<Map<String, String>> data = new ArrayList<Map<String, String>>();

		try {

			// Read Excel File

			FileInputStream Exclfl = new FileInputStream(
					System.getProperty("user.dir") + "\\TestData\\" + excelFileName);

			// Load the file into excel classes

			XSSFWorkbook wb = new XSSFWorkbook(Exclfl);

			// Read the data from specific sheet

			XSSFSheet Exclsheet = wb.getSheet(sheetName);

			// Get total number of rows and columns in data

			int totalRows = Exclsheet.getPhysicalNumberOfRows();
			int totalCols = Exclsheet.getRow(0).getPhysicalNumberOfCells();
			
			for(int r=1;r<totalRows;r++) {
				
				Map<String,String> rowData = new HashMap<String, String>();
				
				for(int col=1;col<totalCols;col++) {
					
					String columnName = Exclsheet.getRow(0).getCell(col).getStringCellValue();
					String columnValue = Exclsheet.getRow(r).getCell(col).getStringCellValue();
					
					rowData.put(columnName, columnValue);
					
					
				}
				
				System.out.println(data.add(rowData));
				
			}
			

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return data;

	}

	public String[][] readExcelDataUsing2DArray(String excelFileName, String sheetName) {

		String[][] data = null;

		return data;

	}

}
