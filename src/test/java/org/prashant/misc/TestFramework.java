package org.prashant.misc;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.opentelemetry.exporter.logging.SystemOutLogExporter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;
import org.testng.annotations.Test;

import java.sql.SQLOutput;

public class TestFramework {
    WebDriver driver;
    @Test
    public void testChromeSetup() {

        driver.findElement(By.cssSelector("#btnLogin")).click();
        //driver.close();

    }
}
