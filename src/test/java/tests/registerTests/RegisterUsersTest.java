package tests.registerTests;

import base.BaseTest;
import config.EnvLoader;
import io.qameta.allure.*;
import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import pages.RegisterPage;
import utils.RandomDataGenerator;

import java.time.Duration;

@Epic("User Admin Automation")
@Feature("User Registration")
@Owner("Ruturaj Darekar")

public class RegisterUsersTest extends BaseTest {

    public static String savedEmail;
    public static String savedPassword;

    @Test
    @Description("Verify registration of 5 users")
    @Severity(SeverityLevel.CRITICAL)
    public void registerFiveUsers() {

        RegisterPage register = new RegisterPage(driver);

        String url = EnvLoader.get("BASE_URL") + "/register";

        for(int i=1;i<=5;i++){

            driver.get(url);

            String name = RandomDataGenerator.generateName();
            String email = RandomDataGenerator.generateEmail();
            String password = EnvLoader.get("TEST_PASSWORD");

            if(i == 1){
                savedEmail = email;
                savedPassword = password;
            }

            register.registerUser(name,email,password);

            handleAlert();
        }
    }

    public void handleAlert(){

        try{

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
            Alert alert = wait.until(ExpectedConditions.alertIsPresent());
            alert.accept();

        }catch(Exception e){

            System.out.println("No alert present");

        }

    }

}