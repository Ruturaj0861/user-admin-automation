package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterPage {

    WebDriver driver;

    public RegisterPage(WebDriver driver){
        this.driver = driver;
    }

    By name = By.xpath("//input[@placeholder='Name']");
    By email = By.xpath("//input[@placeholder='Email']");
    By password = By.xpath("//input[@placeholder='Password']");
    By registerBtn = By.xpath("//button[contains(text(),'Register')]");

    public void registerUser(String n,String e,String p){

        driver.findElement(name).sendKeys(n);
        driver.findElement(email).sendKeys(e);
        driver.findElement(password).sendKeys(p);
        driver.findElement(registerBtn).click();

    }

}