package pageObject;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;

import com.codeborne.selenide.SelenideElement;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.open;


public class RegistrationPage {


    public SelenideElement
            logInButton = $(byXpath("//*[@id=\"__next\"]/header/div[4]/div[1]/div[3]/button[2]")),
            registerButton = $(byXpath( "//*[@id=\"portal-root\"]/div/div/div/span/button[2]")),
            emailInput = $("#email"),
            usernameInput = $("#username"),
            mobileNumber = $("#phone"),
            passwordInput = $("#signup-password"),
            repeatPassword = $("#signup-password-repeat"),
            repeatPasswordIncorrect =$("#signup-password-repeat"),
            createAccountButton = $(byXpath("//*[@id=\"portal-root\"]/div/div/div/form/button[1]"));


}
