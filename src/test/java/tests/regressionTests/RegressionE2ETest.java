package tests.regressionTests;

import base.BaseTest;
import config.EnvLoader;
import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.RegisterPage;
import pages.DashboardPage;

import java.time.Duration;

public class RegressionE2ETest extends BaseTest {

    // Method to safely handle alerts
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
    public void fullRegressionFlow() throws InterruptedException {

        // Get base URL from .env
        String baseUrl = EnvLoader.get("BASE_URL");

        driver.get(baseUrl);

        // Generate dynamic user data
        String name = "User" + System.currentTimeMillis();
        String email = "user" + System.currentTimeMillis() + "@mail.com";
        String password = "Password123";

        // ======================
        // REGISTER USER
        // ======================

        driver.get(baseUrl + "/register");

        RegisterPage register = new RegisterPage(driver);

        register.registerUser(name, email, password);

        handleAlert();

        Thread.sleep(2000);

        // ======================
        // LOGIN USER
        // ======================

        driver.get(baseUrl);

        LoginPage login = new LoginPage(driver);

        login.login(email, password);

        handleAlert();

        Thread.sleep(2000);

        DashboardPage dashboard = new DashboardPage(driver);

        // ======================
        // SEARCH USER
        // ======================

        dashboard.searchUser(name);

        Thread.sleep(2000);

        // ======================
        // UPDATE USER
        // ======================

        dashboard.updateUser();

        handleAlert();

        Thread.sleep(2000);

        // ======================
        // BLOCK USER
        // ======================

        dashboard.blockUser();

        handleAlert();

        Thread.sleep(2000);

        // ======================
        // ACTIVATE USER
        // ======================

        dashboard.activateUser();

        handleAlert();

        Thread.sleep(2000);

        // ======================
        // RESET PASSWORD
        // ======================

        dashboard.resetPassword();

        handleAlert();

        Thread.sleep(2000);

        // ======================
        // UPLOAD IMAGE
        // ======================

        String filePath = System.getProperty("user.dir")
                + "\\src\\test\\resources\\testdata\\profile.png";

        dashboard.uploadImage(filePath);

        handleAlert();

        Thread.sleep(2000);

        // ======================
        // DELETE USER
        // ======================

        dashboard.deleteUser();

        handleAlert();

        Thread.sleep(2000);

        // ======================
        // LOGOUT
        // ======================

        dashboard.logout();

    }
}