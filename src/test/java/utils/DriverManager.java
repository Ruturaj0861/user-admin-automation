package utils;

import config.EnvLoader;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class DriverManager {

    public static WebDriver getDriver(String browser){

        boolean headless = Boolean.parseBoolean(EnvLoader.get("HEADLESS"));

        switch(browser.toLowerCase()){

            case "chrome":

                WebDriverManager.chromedriver().setup();

                ChromeOptions chromeOptions = new ChromeOptions();

                if(headless){
                    chromeOptions.addArguments("--headless=new");
                    chromeOptions.addArguments("--window-size=1920,1080");
                }

                return new ChromeDriver(chromeOptions);


            case "firefox":

                WebDriverManager.firefoxdriver().setup();

                FirefoxOptions firefoxOptions = new FirefoxOptions();

                if(headless){
                    firefoxOptions.addArguments("-headless");
                }

                return new FirefoxDriver(firefoxOptions);


            default:
                throw new RuntimeException("Browser not supported: " + browser);
        }
    }
}