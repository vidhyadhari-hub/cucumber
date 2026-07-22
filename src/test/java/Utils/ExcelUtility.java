package Utils;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ExcelUtility {
    public static Object [][] getData(String SheetName,String filepath){
        Object[][] data=null;
        try{
            FileInputStream file=new FileInputStream(filepath);
            Workbook workbook=new XSSFWorkbook(file);
            Sheet sheet=workbook.getSheet(SheetName);
            int rows=sheet.getLastRowNum();
            int cols=sheet.getRow(0).getLastCellNum();
            data=new Object[rows][cols];
            for(int i=1;i<=rows;i++) {
                Row row = sheet.getRow(i);
                for (int j = 0; j < cols; j++) {
                    Cell cell =row.getCell(j);
                    DataFormatter formatter = new DataFormatter();
                    data[i - 1][j] = formatter.formatCellValue(cell);
                }
            }
            workbook.close();
            file.close();


        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }
}
