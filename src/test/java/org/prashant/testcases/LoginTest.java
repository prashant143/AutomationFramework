package org.prashant.testcases;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.prashant.base.TestBase;
import org.prashant.utilities.ExcelUtils;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.sql.SQLOutput;
import java.util.Arrays;

public class LoginTest extends TestBase {
    ExcelUtils excel = new ExcelUtils();
    public Object[][] testData(){
        int rowCount = excel.getRowCount();
        int colCount = excel.getColCount();
        Object testData[][] = new Object[rowCount-1][colCount];
        for (int row =1;row<rowCount;row++){
            for (int col=0;col<colCount;col++){
                String loginData = excel.getStringData(row,col);
                System.out.print(loginData + " | ");
                testData[row-1][col] = loginData;
            }
        }
        return testData;
    }
    @DataProvider(name = "testData")
    public Object[][] loginWithExcelTestData(){
        Object data[][] =  testData();
        return data;
    }
    @Test(dataProvider ="testData")
    public void loginTest(String userName, String password) throws InterruptedException {
        String orangeHRM = driver.getTitle();
        logger.info(orangeHRM);
        driver.findElement(By.cssSelector("#txtUsername")).sendKeys(userName);
        logger.warn("Entered Admin Username");
        driver.findElement(By.cssSelector("#txtPassword")).sendKeys(password);
        logger.warn("Entered Admin Password");
        driver.findElement(By.cssSelector("#btnLogin")).click();
        logger.warn("Clicked on Login Button");
        if(driver.getCurrentUrl().equals("https://opensource-demo.orangehrmlive.com/index.php/dashboard")) {
            driver.findElement(By.cssSelector("#welcome")).click();
            driver.findElement(By.xpath("//a[contains(text(),'Logout')]")).click();
        }

    }
}
