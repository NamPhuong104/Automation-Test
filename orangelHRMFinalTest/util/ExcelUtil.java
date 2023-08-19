package util;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtil {
	public static FileInputStream fi;
	public static FileOutputStream fo;
	public static XSSFWorkbook wb;
	public static XSSFSheet ws;
	public static XSSFRow row;
	public static XSSFCell cell;
	public static XSSFCellStyle style;
	public static XSSFFont font;
	public static int excelRowResult, excelColumnResult;
	final static Logger logger = Logger.getLogger(ExcelUtil.class);

	public static void openFile(String path, String sheetName) throws Exception {
		try {
			fi = new FileInputStream(path);
			wb = new XSSFWorkbook(fi);
			ws = wb.getSheet(sheetName);
		} catch (Exception e) {
			logger.error("Error message: ", e);
			throw (e);
		}
	}

	public static void setRowColumn(int rowNum, int colNum) throws Exception {
		excelRowResult = rowNum;
		excelColumnResult = colNum;
	}

	public static Integer getRow() throws Exception {
		return excelRowResult;
	}

	public static Integer getColumn() throws Exception {
		return excelColumnResult;
	}

	public static void saveAndCloseFile(String path) throws Exception {
		fo = new FileOutputStream(path);
		wb.write(fo);
		fo.close();
	}

	public static int getRowCount(String path, String sheetName) throws Exception {
		int rowCount;
		fi = new FileInputStream(path);
		wb = new XSSFWorkbook(fi);
		ws = wb.getSheet(sheetName);
		rowCount = ws.getLastRowNum();
		fi.close();
		return rowCount;
	}

	public static int getCellCount(String path, String sheetName, int rowNum) throws Exception {
		int cellCount;
		fi = new FileInputStream(path);
		wb = new XSSFWorkbook(fi);
		ws = wb.getSheet(sheetName);
		row = ws.getRow(rowNum);
		cellCount = row.getLastCellNum();
		fi.close();
		return cellCount;
	}

	public static String getCellData(int rowNum, int colNum) throws Exception {
		try {
			cell = ws.getRow(rowNum).getCell(colNum);
			String cellData = cell.getStringCellValue();
			return cellData;
		} catch (Exception e) {
			return "";
		}
	}

	public static Integer getNumericCellData(int rowNum, int colNum) throws Exception {
		try {
			cell = ws.getRow(rowNum).getCell(colNum);
			Integer cellData = (int) cell.getNumericCellValue();
			return cellData;
		} catch (Exception e) {
			return null;
		}
	}

	public static String getDateCellData(int rowNum, int colNum, String format) throws Exception {
		try {
			cell = ws.getRow(rowNum).getCell(colNum);
			final DateFormat dateFormat = new SimpleDateFormat(format);
			String cellData = dateFormat.format(cell.getDateCellValue());
			return cellData;
		} catch (Exception e) {
			if (!cell.getStringCellValue().isEmpty()) {
				return cell.getStringCellValue();
			}
			return "";
		}
	}

	public static void setCellData(int rowNum, int colNum, String status) throws Exception {
		try {
			row = ws.getRow(rowNum);
			if (row == null) {
				row = ws.createRow(rowNum);
			}
			cell = row.getCell(colNum);
			if (cell == null) {
				cell = row.createCell(colNum);
			}
			cell.setCellValue(status);
			font = wb.createFont();
			setCommonFont(false, 12);
			style = wb.createCellStyle();
			setCommonStyle();
			style.setFont(font);
			cell.setCellStyle(style);
		} catch (Exception e) {
			return;
		}
	}

	public static void setCellDataResult(int rowNum, int colNum, String status) throws Exception {
		try {
			row = ws.getRow(rowNum);
			if (row == null) {
				row = ws.createRow(rowNum);
			}
			cell = row.getCell(colNum);
			if (cell == null) {
				cell = row.createCell(colNum);
			}
			cell.setCellValue(status);
			font = wb.createFont();
			setCommonFont(true, 13);
			style = wb.createCellStyle();
			setCommonStyle();
			style.setFont(font);
			cell.setCellStyle(style);
		} catch (Exception e) {
			return;
		}
	}

	public static void fillGreenColour(int rowNum, int colNum) throws Exception {
		row = ws.getRow(rowNum);
		cell = row.getCell(colNum);
		font = wb.createFont();
		setCommonFont(true, 13);
		style = wb.createCellStyle();
		style.setFillForegroundColor(IndexedColors.GREEN.getIndex());
		style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		setCommonStyle();
		style.setFont(font);
		cell.setCellStyle(style);
	}

	public static void fillRedColour(int rowNum, int colNum) throws Exception {
		row = ws.getRow(rowNum);
		cell = row.getCell(colNum);
		font = wb.createFont();
		setCommonFont(true, 13);
		style = wb.createCellStyle();
		style.setFillForegroundColor(IndexedColors.RED.getIndex());
		style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		setCommonStyle();
		style.setFont(font);
		cell.setCellStyle(style);
	}

	public static void setCommonStyle() throws Exception {
		style.setAlignment(CellStyle.ALIGN_CENTER);
		style.setVerticalAlignment(CellStyle.VERTICAL_CENTER);
		style.setBorderTop(HSSFCellStyle.BORDER_THIN);
		style.setBorderBottom(HSSFCellStyle.BORDER_THIN);
		style.setBorderLeft(HSSFCellStyle.BORDER_THIN);
		style.setBorderRight(HSSFCellStyle.BORDER_THIN);
		style.setWrapText(true);
	}

	public static void setCommonFont(boolean isBool, int fontSize) throws Exception {
		font.setFontName("Times New Roman");
		font.setBold(isBool);
		font.setFontHeightInPoints((short) fontSize);
	}
}