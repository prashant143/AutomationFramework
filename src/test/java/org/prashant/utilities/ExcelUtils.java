package org.prashant.utilities;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.IOException;

public class ExcelUtils {
    static XSSFWorkbook loginTestDataSheet;
    static XSSFSheet testDataSheet;
    public static int getRowCount(){
        sheetSetUp();
        int rowCount = testDataSheet.getPhysicalNumberOfRows();
        //System.out.println(rowCount);
        return rowCount;
    }
    public static int getColCount(){
        sheetSetUp();
        int colCount = testDataSheet.getRow(0).getPhysicalNumberOfCells();
        //System.out.println(colCount);
        return colCount;
    }
    public static String getStringData(int rowNum, int colNum){
        sheetSetUp();
        String getLoginData= testDataSheet.getRow(rowNum).getCell(colNum).getStringCellValue();
        //System.out.println(adminUsername);
        return getLoginData;
    }
    public static int getNumericData(int rowNum, int colNum){
        sheetSetUp();
        int getLoginNumData = (int) testDataSheet.getRow(rowNum).getCell(colNum).getNumericCellValue();
        //System.out.println(numberData);
        return getLoginNumData;
    }
    public static void sheetSetUp(){
        try {
            loginTestDataSheet = new XSSFWorkbook(System.getProperty("user.dir") + "/src/test/resources/excel/testdata.xlsx");
            testDataSheet = loginTestDataSheet.getSheet("loginData");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
