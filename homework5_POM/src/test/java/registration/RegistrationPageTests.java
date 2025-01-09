package registration;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.Assert;
import org.testng.annotations.Test;
import stepObject.RegistrationPageSteps;
import utils.ChromeRunner;

import static dataObject.RegistrationPageData.*;

public class RegistrationPageTests extends ChromeRunner {

    RegistrationPageSteps registrationPageSteps = new RegistrationPageSteps();

    @Test
    @Severity(SeverityLevel.CRITICAL)
    @Description("Case with positive Inputs")
    public void registrationPageCase(){
        registrationPageSteps
                .goToLogIn()
                .goToRegister()
                .emailField(email)
                .userNameField(username)
                .mobileNumberField(mobileNumber)
                .passwordField(password)
                .repeatPasswordField(repeatPassword)
                .goToCreateAccount();
        Assert.assertTrue(registrationPageSteps.createAccountButton.is(Condition.enabled));


    }

    @Test
    public void registrationPageNegative(){
        registrationPageSteps
                .goToLogIn()
                .goToRegister()
                .emailField(email)
                .userNameField(username)
                .mobileNumberField(mobileNumber)
                .passwordField(password)
                .repeatPasswordInCorr(repeatPasswordIncorrect)
                .goToCreateAccount();
        Assert.assertNotEquals(registrationPageSteps.repeatPasswordIncorrect.getValue(),registrationPageSteps.passwordInput.getValue());

    }
}
