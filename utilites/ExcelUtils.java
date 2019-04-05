package utilites;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row.MissingCellPolicy;

public class ExcelUtils {
	private static HSSFWorkbook excel;
	private static HSSFSheet sheet;
	private static HSSFRow row;
	private static HSSFCell cell;
	private static DataFormatter formatter;

	// Method for setting an excel file
	public static void setExcelFile(String path, String str) throws IOException {
		try {
			FileInputStream file = new FileInputStream(path);
			excel = new HSSFWorkbook(file);
			sheet = excel.getSheet(str);
			formatter = new DataFormatter();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	// Method for getting cell data from specific cell (by entering row number and
	// column number)
	public static String getCell(int row, int col) {
		cell = sheet.getRow(row).getCell(col);
		String CellData = formatter.formatCellValue(cell);

		return CellData;
	}

	// Method for setting up cell data in specific cell (by entering row number and
	// column number)
	public static void setCellData(String Result, int RowNum, int ColNum) throws Exception {
		try {
			row = sheet.getRow(RowNum);
			cell = row.getCell(ColNum, MissingCellPolicy.RETURN_BLANK_AS_NULL);
			if (cell == null) {
				cell = row.createCell(ColNum);
				cell.setCellValue(Result);
			} else {
				cell.setCellValue(Result);
			}
			FileOutputStream fileOut = new FileOutputStream(Constant.FILE_PATH + Constant.FILE_NAME);
			excel.write(fileOut);
			fileOut.flush();
			fileOut.close();
		} catch (Exception e) {
			throw (e);

		}

	}

	// Method for getting work sheet
	public static HSSFSheet getWSheet() {
		return sheet;
	}

}
