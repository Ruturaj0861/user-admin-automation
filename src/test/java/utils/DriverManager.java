package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverManager {

    public static WebDriver getDriver(String browser) {

        WebDriver driver;

        switch (browser.toLowerCase()) {

            case "edge":

                try {
                    WebDriverManager.edgedriver().setup();
                    driver = new EdgeDriver();
                } catch (Exception e) {

                    System.out.println("Edge driver download failed, switching to Chrome");

                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                }

                break;

            case "firefox":

                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;

            default:

                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
        }

        driver.manage().window().maximize();

        return driver;
    }
}