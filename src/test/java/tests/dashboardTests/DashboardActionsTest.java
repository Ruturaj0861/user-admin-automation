package tests.dashboardTests;
import java.nio.file.Paths;

import base.BaseTest;
import config.EnvLoader;
import io.qameta.allure.*;
import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import pages.DashboardPage;
import pages.LoginPage;
import tests.registerTests.RegisterUsersTest;

import java.time.Duration;

@Epic("User Admin Automation")
@Feature("Dashboard Functionalities")
@Owner("Ruturaj Darekar")

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
    @Description("Verify search user functionality")
    @Severity(SeverityLevel.NORMAL)
    public void searchUserTest() {

        loginToApplication();
        dashboard.searchUser("User");

    }

    @Test(priority = 2)
    @Description("Verify update user functionality")
    @Severity(SeverityLevel.CRITICAL)
    public void updateUserTest() {

        loginToApplication();
        dashboard.updateUser();
        handleAlert();

    }

    @Test(priority = 3)
    @Description("Verify block user functionality")
    @Severity(SeverityLevel.CRITICAL)
    public void blockUserTest() {

        loginToApplication();
        dashboard.blockUser();
        handleAlert();

    }

    @Test(priority = 4)
    @Description("Verify activate user functionality")
    @Severity(SeverityLevel.CRITICAL)
    public void activateUserTest() {

        loginToApplication();
        dashboard.activateUser();
        handleAlert();

    }

    @Test(priority = 5)
    @Description("Verify reset password functionality")
    @Severity(SeverityLevel.CRITICAL)
    public void resetPasswordTest() {

        loginToApplication();
        dashboard.resetPassword();
        handleAlert();

    }

    @Test(priority = 6)
    @Description("Verify upload image functionality")
    @Severity(SeverityLevel.CRITICAL)
    public void uploadImageTest() {

        loginToApplication();

        String filePath = Paths.get(
                System.getProperty("user.dir"),
                "src",
                "test",
                "resources",
                "src/test/new/testdata",
                "profile.png"
        ).toString();

        dashboard.uploadImage(filePath);

    }

    @Test(priority = 7)
    @Description("Verify logout functionality")
    @Severity(SeverityLevel.NORMAL)
    public void logoutTest() {

        loginToApplication();
        dashboard.logout();

    }

    @Test(priority = 8)
    @Description("Verify delete user functionality")
    @Severity(SeverityLevel.CRITICAL)
    public void deleteUserTest() {

        loginToApplication();
        dashboard.deleteUser();
        handleAlert();

    }

}