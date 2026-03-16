package tests.dashboardTests;

import base.BaseTest;
import config.EnvLoader;
import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import pages.DashboardPage;
import pages.LoginPage;
import tests.registerTests.RegisterUsersTest;

import java.time.Duration;

public class DashboardActionsTest extends BaseTest {

    LoginPage login;
    DashboardPage dashboard;

    public void loginToApplication() {

        driver.get(EnvLoader.get("BASE_URL"));

        login = new LoginPage(driver);

        login.login(RegisterUsersTest.savedEmail,
                RegisterUsersTest.savedPassword);

        handleAlert();

        dashboard = new DashboardPage(driver);

    }

    public void handleAlert() {

        try {

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
            Alert alert = wait.until(ExpectedConditions.alertIsPresent());
            alert.accept();

        } catch (Exception e) {

            System.out.println("No alert present");

        }

    }

    @Test(priority = 1)
    public void searchUserTest() {

        loginToApplication();

        dashboard.searchUser("User");

    }

    @Test(priority = 2)
    public void updateUserTest() {

        loginToApplication();

        dashboard.updateUser();

        handleAlert();

    }

    @Test(priority = 3)
    public void blockUserTest() {

        loginToApplication();

        dashboard.blockUser();

        handleAlert();

    }

    @Test(priority = 4)
    public void activateUserTest() {

        loginToApplication();

        dashboard.activateUser();

        handleAlert();

    }

    @Test(priority = 5)
    public void resetPasswordTest() {

        loginToApplication();

        dashboard.resetPassword();

        handleAlert();

    }

    @Test(priority = 6)
    public void uploadImageTest() {

        loginToApplication();

        String filePath = System.getProperty("user.dir")
                + "\\src\\test\\resources\\testdata\\profile.png";

        dashboard.uploadImage(filePath);

    }

    @Test(priority = 7)
    public void logoutTest() {

        loginToApplication();

        dashboard.logout();

    }

    @Test(priority = 8)
    public void deleteUserTest() {

        loginToApplication();

        dashboard.deleteUser();

        handleAlert();

    }

}