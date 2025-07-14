package Tests;

import java.util.List;
import java.util.Map;

import Utilities.ExcelUtil;

public class ReadExcelData {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		List<Map<String, String>> Exceldata = ExcelUtil.readexcelDataUsingCollections("Assignment 5.xlsx", "StudentDetails");
		List<Map<String, String>> Exceldata2 = ExcelUtil.readexcelDataUsingCollections("Assignment 5.xlsx", "EmployeeDetails");
		List<Map<String, String>> Exceldata3 = ExcelUtil.readexcelDataUsingCollections("Assignment 5.xlsx", "ProductDetails");
		
		System.out.println(Exceldata);
		System.out.println(Exceldata2);
		System.out.println(Exceldata3.get(1).get("Supplier"));
		
		

	}

}
