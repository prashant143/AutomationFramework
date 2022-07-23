package org.prashant.testcases;
import org.openqa.selenium.By;
import org.prashant.base.TestBase;
import org.testng.annotations.Test;

public class LoginTest extends TestBase {


    @Test
    public void loginTest(){
        String orangeHRM = driver.getTitle();
        logger.info(orangeHRM);
        driver.findElement(By.cssSelector("#txtUsername")).sendKeys("Admin");
        logger.warn("Entered Admin Username");
        driver.findElement(By.cssSelector("#txtPassword")).sendKeys("admin123");
        logger.warn("Entered Admin Password");
        driver.findElement(By.cssSelector("#btnLogin")).click();
        logger.warn("Clicked on Login Button");

    }
}
