package tests.loginTests;

import base.BaseTest;
import config.EnvLoader;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginTest extends BaseTest {

    @Test
    public void loginUser(){

        driver.get(EnvLoader.get("BASE_URL"));

        LoginPage login = new LoginPage(driver);

        login.login("automation_testing1@gmail.com",
                EnvLoader.get("TEST_PASSWORD"));

    }

}