package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class GlobalParams {

    public WebDriver driver = null;

    @Test
    public void Login() throws IOException {

        System.setProperty("webdriver.chrome.driver", "/Users/singh2_rajiv/Automation/Selenium/Drivers/chromedriver");

        Properties prop = new Properties();
        FileInputStream fis = new FileInputStream("/Users/singh2_rajiv/Selenium/TestNGTutorial/src/test/datadriven.properties");
        prop.load(fis);

        System.out.println(prop.getProperty("username"));

        if (prop.getProperty("browser").equals("firefox")) {
            driver = new FirefoxDriver();
        }

        else if (prop.getProperty("browser").equals("chrome")) {
            driver = new ChromeDriver();
        }

        else if (prop.getProperty("browser").equals("ie")) {
            driver = new InternetExplorerDriver();
        }

        driver.get(prop.getProperty("url"));

    }
}
