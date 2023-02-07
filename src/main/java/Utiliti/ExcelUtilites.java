package Utiliti;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class ExcelUtilites {
	@DataProvider
	public static Object[][] getTextData() throws IOException {

		FileInputStream fis=new FileInputStream("C:\\Users\\win10\\eclipse-workspace\\Sample\\Iterea.xlsx");

		XSSFWorkbook work=new XSSFWorkbook(fis);
		XSSFSheet sheet=work.getSheetAt(0);
		int rowNo=sheet.getLastRowNum();
		int cellNo=sheet.getRow(0).getLastCellNum();
		System.out.println(rowNo);
		System.out.println(cellNo);

		Object[][] data=new Object[rowNo][cellNo];
		for(int i=1; i<=rowNo; i++) {

			for(int j=0; j<cellNo; j++) {
				data[i-1][j]=sheet.getRow(i).getCell(j).getStringCellValue();

			}
		}
		return data;

	}
	@DataProvider(name="getTextData1", parallel = true)
	public static Object[] getTextData1() throws IOException {

		FileInputStream fis=new FileInputStream("C:\\Users\\win10\\eclipse-workspace\\Sample\\Iterea.xlsx");

		XSSFWorkbook work=new XSSFWorkbook(fis);
		XSSFSheet sheet=work.getSheetAt(0);
		int rowNo=sheet.getLastRowNum();
		int cellNo=sheet.getRow(0).getLastCellNum();
		System.out.println(rowNo);
		System.out.println(cellNo);

		Object[] data=new Object[rowNo];
		Map<String,String>map;
		for(int i=1; i<=rowNo; i++) {
			map=new HashMap<String, String>();
			for(int j=0; j<cellNo; j++) {

				String key=sheet.getRow(0).getCell(j).getStringCellValue();
				String value=sheet.getRow(i).getCell(j).getStringCellValue();
				map.put(key, value);

			}
			data[i-1]=map;

		}
		return data;
	}
	//@DataProvider(name="getTextData2")
	public static List<String> getTextData2() throws IOException {

		FileInputStream fis=new FileInputStream("C:\\Users\\win10\\eclipse-workspace\\Sample\\Iterea.xlsx");

		XSSFWorkbook work=new XSSFWorkbook(fis);
		XSSFSheet sheet=work.getSheetAt(0);
		int rowNo=sheet.getLastRowNum();
		int cellNo=sheet.getRow(0).getLastCellNum();
		System.out.println(rowNo);
		System.out.println(cellNo);

		List<String>list=new ArrayList<String>();
		Map<String,String>map;
		for(int i=1; i<=rowNo; i++) {
			map=new HashMap<String, String>();
			for(int j=0; j<cellNo; j++) {

				String key=sheet.getRow(0).getCell(j).getStringCellValue();
				String value=sheet.getRow(i).getCell(j).getStringCellValue();
				map.put(key, value);

			}
			list.addAll((Collection<? extends String>) map);
		 

		}
		return list;
		
	}



}
