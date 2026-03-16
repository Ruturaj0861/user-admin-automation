package base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import utils.DriverManager;

public class BaseTest {

    protected WebDriver driver;

    @Parameters("browser")
    @BeforeMethod
    public void setup(String browser){

        driver = DriverManager.getDriver(browser);

    }

    @AfterMethod
    public void tearDown(){

        if(driver != null){
            driver.quit();
        }

    }

}