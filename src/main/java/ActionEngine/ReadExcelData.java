package ActionEngine;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;



public class ReadExcelData extends Resuable.ReusableMethods {
	static File file;
	static FileInputStream inputStream;
	static Workbook workbook;
	protected static Sheet sheet;
	protected static Row row;
	protected static Cell cell;
	CellStyle style;
	String[][] data;

	public void readExcel(String filePath, String fileName) {

		// Create an object of File class to open xlsx file

		file = new File(filePath + "\\" + fileName);

		// Create an object of FileInputStream class to read excel file

		try {
			inputStream = new FileInputStream(file);

			workbook = null;

			// Find the file extension by splitting file name in substring and getting only
			// extension name

			String fileExtensionName = fileName.substring(fileName.indexOf("."));

			// Check condition if the file is xlsx file

			if (fileExtensionName.equals(".xlsx")) {

				// If it is xlsx file then create object of XSSFWorkbook class

				workbook = new XSSFWorkbook(inputStream);

			}

			// Check condition if the file is xls file

			else if (fileExtensionName.equals(".xls")) {

				// If it is xls file then create object of HSSFWorkbook class

				workbook = new HSSFWorkbook(inputStream);

			}
		}

		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public Sheet getSheet(String sheetName) {

// Read sheet inside the workbook by its name

		sheet = workbook.getSheet(sheetName);
		return sheet;
	}

	public int totalRowCount() {
		int rowCount = sheet.getLastRowNum();
		return rowCount;
	}

	public String getCellValue(int rowNum, int columnNum) {
		row = sheet.getRow(rowNum);
		cell = row.getCell(columnNum);
		String value = getCellValueAsString(cell);
		return value;
	}

	public String getSheetName(int index) {
		String sheet = workbook.getSheetName(index);
		return sheet;
	}

	public int getSheetCount() {
		int sheetCount = workbook.getNumberOfSheets();
		return sheetCount;
	}

	public int totolColumnCount() {
		row = sheet.getRow(0);
		int lastColumnNum = row.getLastCellNum();
		return lastColumnNum;
	}

	public String getCellValueAsString(Cell cell) {
		DataFormatter formatter = new DataFormatter();
		String cellValue = null;
		cellValue = formatter.formatCellValue(cell);

//		switch (cell.getCellType()) {
//		case NUMERIC:
//			cellValue = String.valueOf(cell.getNumericCellValue());
//			break;
//		case STRING:
//			cellValue = cell.getStringCellValue();
//			break;
//		case BOOLEAN:
//			cellValue = String.valueOf(cell.getBooleanCellValue());
//			break;
//		case FORMULA:
//			cellValue = cell.getCellFormula();
//		case BLANK:
//			cellValue = "BLANK";
//		default:
//			cellValue = "DEFAULT";
//		}
		return cellValue;
	}

	
	
	@DataProvider(name = "excel")
		public String[][] readingData() {

			data = null;
			//readExcel("C:\\Users\\VEERA BABU\\Desktop", "testExcel.xlsx");
			//getSheet("Sheet1");
			
			readExcel("C:\\Users\\pasupuleti.swamy\\Desktop", "exel.xls");
			//readExcel("C:\\Users\\VEERA BABU\\Desktop", "testExcel.xlsx");
			

			getSheet("Sheet1");
			
			int noOfRows = totalRowCount();
			int noOfColumns = totolColumnCount();
			int ci = 0, cj = 0;
			data = new String[noOfRows][noOfColumns];
			for (int row = 1; row <= noOfRows; row++) {
				for (int column = 0; column < noOfColumns; column++) {
					data[row - 1][column] = getCellValue(row, column);
				}

			}

			return data;
		}

	
}
//		// Find number of rows in excel file
//
//		int rowCount = Sheet.getLastRowNum() - Sheet.getFirstRowNum();
//
//		// Create a loop over all the rows of excel file to read it
//
//		for (int i = 0; i < rowCount + 1; i++) {
//
//			Row row = Sheet.getRow(i);
//
//			// Create a loop to print cell values in a row
//
//			for (int j = 0; j < row.getLastCellNum(); j++) {
//
//				Cell cell = row.getCell(j);
//				switch (cell.getCellType()) {
//				case NUMERIC:
//					double doubleVal = cell.getNumericCellValue();
//					System.out.println(String.valueOf(doubleVal));
//					break;
//
//				case STRING:
//					System.out.println(cell.getStringCellValue());
//
//				default:
//					break;
//				}
//				// Print Excel data in console
//
//			}
//
//			System.out.println();
//		}
