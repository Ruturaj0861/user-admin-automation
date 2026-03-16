package base;

import io.qameta.allure.Allure;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import utils.DriverManager;

public class BaseTest {

    protected WebDriver driver;

    @BeforeMethod
    @Parameters("browser")
    public void setup(String browser){

        driver = DriverManager.getDriver(browser);

        Allure.parameter("Browser", browser);

    }

    @AfterMethod
    public void tearDown(){

        if(driver != null){

            driver.quit();

        }

    }

}