package test1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {

	public static Object[][] readExcel (String sheetname) {
		Object[][] obj = null;
		File file = new File("src/test/resources/testData/dataDriven.xlsx");
		InputStream xbook;

		try {
			xbook = new FileInputStream(file);
			XSSFWorkbook workbook = new XSSFWorkbook(xbook);
			XSSFSheet sheet = workbook.getSheet(sheetname);

			obj = new Object[sheet.getLastRowNum()][];
			for(int i=1; i<=sheet.getLastRowNum(); i++) {
				obj[i-1]=new Object[sheet.getRow(i).getPhysicalNumberOfCells()];
				for(int j=0; j<sheet.getRow(i).getPhysicalNumberOfCells(); j++) {
					obj[i-1][j] = sheet.getRow(i).getCell(j).getStringCellValue();
					System.out.println(sheet.getRow(i).getCell(j).getStringCellValue());
				}
			}
			workbook.close();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return obj;

	}
}
