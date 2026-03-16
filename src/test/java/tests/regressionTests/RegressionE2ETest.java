package tests.regressionTests;

import base.BaseTest;
import config.EnvLoader;
import io.qameta.allure.*;
import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.RegisterPage;
import pages.DashboardPage;

import java.time.Duration;

@Epic("User Admin Automation")
@Feature("End-to-End Regression")
@Owner("Ruturaj Darekar")

public class RegressionE2ETest extends BaseTest {

    public void handleAlert() {

        try {

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
            Alert alert = wait.until(ExpectedConditions.alertIsPresent());

            System.out.println("Alert message: " + alert.getText());

            alert.accept();

        } catch (Exception e) {

            System.out.println("No alert present");

        }

    }

    @Test
    @Description("Verify full end-to-end user flow including register, login, dashboard actions and logout")
    @Severity(SeverityLevel.BLOCKER)
    public void fullRegressionFlow() throws InterruptedException {

        String baseUrl = EnvLoader.get("BASE_URL");

        driver.get(baseUrl);

        String name = "User" + System.currentTimeMillis();
        String email = "user" + System.currentTimeMillis() + "@mail.com";
        String password = "Password123";

        driver.get(baseUrl + "/register");

        RegisterPage register = new RegisterPage(driver);

        register.registerUser(name, email, password);

        handleAlert();

        Thread.sleep(2000);

        driver.get(baseUrl);

        LoginPage login = new LoginPage(driver);

        login.login(email, password);

        handleAlert();

        Thread.sleep(2000);

        DashboardPage dashboard = new DashboardPage(driver);

        dashboard.searchUser(name);

        Thread.sleep(2000);

        dashboard.updateUser();

        handleAlert();

        Thread.sleep(2000);

        dashboard.blockUser();

        handleAlert();

        Thread.sleep(2000);

        dashboard.activateUser();

        handleAlert();

        Thread.sleep(2000);

        dashboard.resetPassword();

        handleAlert();

        Thread.sleep(2000);

        String filePath = System.getProperty("user.dir")
                + "\\src\\test\\resources\\testdata\\profile.png";

        dashboard.uploadImage(filePath);

        handleAlert();

        Thread.sleep(2000);

        dashboard.deleteUser();

        handleAlert();

        Thread.sleep(2000);

        dashboard.logout();

    }
}