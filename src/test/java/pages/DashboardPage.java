package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DashboardPage {

    WebDriver driver;

    public DashboardPage(WebDriver driver) {
        this.driver = driver;
    }

    By searchBox = By.xpath("//input[@placeholder='Search user']");
    By searchBtn = By.xpath("//button[contains(text(),'Search')]");

    By updateBtn = By.xpath("(//button[contains(text(),'Update')])[1]");
    By deleteBtn = By.xpath("(//button[contains(text(),'Delete')])[1]");
    By blockBtn = By.xpath("(//button[contains(text(),'Block')])[1]");
    By activateBtn = By.xpath("(//button[contains(text(),'Activate')])[1]");
    By resetBtn = By.xpath("(//button[contains(text(),'Reset')])[1]");

    By uploadInput = By.xpath("(//input[@type='file'])[1]");

    By logoutBtn = By.xpath("//button[contains(text(),'Logout')]");

    public void searchUser(String name) {

        driver.findElement(searchBox).clear();
        driver.findElement(searchBox).sendKeys(name);
        driver.findElement(searchBtn).click();

    }

    public void updateUser() {

        driver.findElement(updateBtn).click();

    }

    public void deleteUser() {

        driver.findElement(deleteBtn).click();

    }

    public void blockUser() {

        driver.findElement(blockBtn).click();

    }

    public void activateUser() {

        driver.findElement(activateBtn).click();

    }

    public void resetPassword() {

        driver.findElement(resetBtn).click();

    }

    public void uploadImage(String filePath) {

        driver.findElement(uploadInput).sendKeys(filePath);

    }

    public void logout() {

        driver.findElement(logoutBtn).click();

    }

}