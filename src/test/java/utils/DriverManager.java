package utils;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class DriverManager {

    public static WebDriver getDriver(String browser){

        WebDriver driver;

        if(browser.equalsIgnoreCase("chrome")){

            WebDriverManager.chromedriver().setup();

            ChromeOptions options = new ChromeOptions();
            options.addArguments("--headless=new");

            driver = new ChromeDriver(options);

        }
        else if(browser.equalsIgnoreCase("edge")){

            WebDriverManager.edgedriver().setup();

            EdgeOptions options = new EdgeOptions();
            options.addArguments("--headless=new");

            driver = new EdgeDriver(options);

        }
        else if(browser.equalsIgnoreCase("firefox")){

            WebDriverManager.firefoxdriver().setup();

            FirefoxOptions options = new FirefoxOptions();
            options.addArguments("--headless");

            driver = new FirefoxDriver(options);

        }
        else{

            throw new RuntimeException("Browser not supported: " + browser);

        }

        driver.manage().window().maximize();

        return driver;

    }
}