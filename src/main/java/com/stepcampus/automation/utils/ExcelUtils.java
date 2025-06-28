package com.stepcampus.automation.utils;

import java.io.FileInputStream;
import java.text.SimpleDateFormat;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {
	public static String getValue(String filePath, String sheetName, String fieldName) {
        try (FileInputStream fis = new FileInputStream(filePath);
             Workbook workbook = new XSSFWorkbook(fis)) {

            Sheet sheet = workbook.getSheet(sheetName);
            if (sheet == null) {
                throw new RuntimeException("Sheet '" + sheetName + "' not found.");
            }

            for (Row row : sheet) {
                Cell keyCell = row.getCell(0); // Field name
                Cell valueCell = row.getCell(1); // Corresponding value

                if (keyCell != null && fieldName.equalsIgnoreCase(getCellValueAsString(keyCell))) {
                    return getCellValueAsString(valueCell);
                }
            }

            throw new RuntimeException("Field '" + fieldName + "' not found in sheet '" + sheetName + "'");
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error reading Excel file: " + e.getMessage());
        }
    }

    private static String getCellValueAsString(Cell cell) {
        if (cell == null) return "";

        switch (cell.getCellType()) {
            case STRING:
                return cell.getStringCellValue().trim();

            case NUMERIC:
                if (DateUtil.isCellDateFormatted(cell)) {
                    return new SimpleDateFormat("yyyy-MM-dd").format(cell.getDateCellValue());
                } else {
                    double val = cell.getNumericCellValue();
                    return (val == Math.floor(val)) ? String.valueOf((long) val) : String.valueOf(val);
                }

            case BOOLEAN:
                return String.valueOf(cell.getBooleanCellValue());

            case FORMULA:
                return getCellValueAsString(evaluateFormulaCell(cell));

            case BLANK:
                return "";

            default:
                return cell.toString().trim();
        }
    }

    private static Cell evaluateFormulaCell(Cell cell) {
        FormulaEvaluator evaluator = cell.getSheet().getWorkbook().getCreationHelper().createFormulaEvaluator();
        return evaluator.evaluateInCell(cell);
    }
}
