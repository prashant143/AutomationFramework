package org.prashant.base;

import ch.qos.logback.classic.Logger;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;
import org.prashant.misc.TestFramework;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class TestBase {
    public static WebDriver driver;
    public static Properties config = new Properties();
    public static Properties OR = new Properties();
    public static FileInputStream fis;
    public static Logger logger = (Logger) LoggerFactory.getLogger(TestBase.class);
    //setUo method will be executed before any other method/suite
    @BeforeSuite
    public void setUp() throws IOException {

        if(driver==null) {
            fis = new FileInputStream(System.getProperty("user.dir") +
                    "/src/test/resources/properties/config.properties");
            config.load(fis);
            logger.warn("Config File Loaded!");
            fis = new FileInputStream(System.getProperty("user.dir") +
                    "/src/test/resources/properties/OR.properties");
            OR.load(fis);

            if (config.getProperty("browser").equals("firefox")) {
                WebDriverManager.firefoxdriver().setup();
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                driver = new FirefoxDriver(firefoxOptions);
                logger.info("Firefox browser launched");
            } else if (config.getProperty("browser").equals("chrome")) {
                WebDriverManager.chromedriver().setup();
                ChromeOptions chromeOptions = new ChromeOptions();
                driver = new ChromeDriver(chromeOptions);
                logger.info("Chrome browser launched");
            } else if (config.getProperty("browser").equals("ie")) {
                WebDriverManager.iedriver().setup();
                InternetExplorerOptions internetExplorerOptions = new InternetExplorerOptions();
                driver = new InternetExplorerDriver(internetExplorerOptions);
                logger.info("IE browser launched");
            } else if (config.getProperty("browser").equals("edge")) {
                WebDriverManager.edgedriver().setup();
                EdgeOptions edgeOptions = new EdgeOptions();
                driver = new EdgeDriver(edgeOptions);
                logger.info("Edge browser launched");
            } else if (config.getProperty("browser").equals("safari")) {
                WebDriverManager.safaridriver().setup();
                SafariOptions safariOptions = new SafariOptions();
                driver = new SafariDriver(safariOptions);
                logger.info("Safari browser launched");
            } else {
                System.out.println("Browser name is empty in the Config file");
            }
            driver.get(config.getProperty("testsiteurl"));
            logger.info("Navigated to " + config.getProperty("testsiteurl"));
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        }
    }
    //tearDown method will be executed after the execution
    @AfterSuite
    public void tearDown(){
        if(driver!=null){
            driver.close();
        }
    }

    public static void main(String[] args) {


    }
}
