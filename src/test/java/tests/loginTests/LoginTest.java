package tests.loginTests;

import base.BaseTest;
import config.EnvLoader;
import io.qameta.allure.*;
import org.testng.annotations.Test;
import pages.LoginPage;

@Epic("User Admin Automation")
@Feature("Login Module")
@Owner("Ruturaj Darekar")

public class LoginTest extends BaseTest {

    @Test
    @Description("Verify user login with valid credentials")
    @Severity(SeverityLevel.CRITICAL)
    public void loginUser(){

        driver.get(EnvLoader.get("BASE_URL"));

        LoginPage login = new LoginPage(driver);

        login.login("automation_testing1@gmail.com",
                EnvLoader.get("TEST_PASSWORD"));

    }

}