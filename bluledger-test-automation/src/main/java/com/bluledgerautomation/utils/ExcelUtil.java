package com.bluledgerautomation.utils;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtil {

    public static Object[][] getData(String path, String sheetName) {
        try {
            FileInputStream fis = new FileInputStream(path);
            Workbook wb = WorkbookFactory.create(fis);
            Sheet sheet = wb.getSheet(sheetName);

            if (sheet == null) {
                throw new RuntimeException("Sheet not found: " + sheetName);
            }

            int rows = sheet.getPhysicalNumberOfRows();
            int cols = sheet.getRow(0).getPhysicalNumberOfCells();

            Object[][] data = new Object[rows - 1][cols];

            DataFormatter formatter = new DataFormatter();

            for (int i = 1; i < rows; i++) {
                Row row = sheet.getRow(i);

                if (row == null) {
                    continue;
                }

                for (int j = 0; j < cols; j++) {
                    Cell cell = row.getCell(j);

                    if (cell == null) {
                        data[i - 1][j] = "";
                    } else {
                        data[i - 1][j] = formatter.formatCellValue(cell);
                    }
                }
            }

            wb.close();
            fis.close();

            return data;

        } catch (Exception e) {
            throw new RuntimeException("Error reading Excel file: " + path, e);
        }
    }
}