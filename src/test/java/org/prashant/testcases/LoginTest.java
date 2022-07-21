package org.prashant.testcases;

import org.openqa.selenium.By;
import org.prashant.base.TestBase;
import org.testng.annotations.Test;

public class LoginTest extends TestBase {

    @Test
    public void loginTest(){
        driver.findElement(By.cssSelector("#txtUsername")).sendKeys("Admin");
        driver.findElement(By.cssSelector("#txtPassword")).sendKeys("admin123");
        driver.findElement(By.cssSelector("#btnLogin")).click();
    }
}
