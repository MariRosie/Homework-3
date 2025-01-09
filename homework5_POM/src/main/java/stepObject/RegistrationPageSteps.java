package stepObject;

import io.qameta.allure.Step;
import org.testng.annotations.Test;
import pageObject.RegistrationPage;



public class RegistrationPageSteps extends RegistrationPage {
    @Step("Click LogIn Button")
    public RegistrationPageSteps goToLogIn() {
        logInButton.click();
        return this;
    }

    @Step("click Register button")
    public RegistrationPageSteps goToRegister() {
        registerButton.click();
        return this;
    }

    @Step("fill Username Value:{0}")
    public RegistrationPageSteps userNameField(String name) {
        usernameInput.setValue(name);
        return this;
    }

    @Step("fill email field Value:{0}")
    public RegistrationPageSteps emailField(String email) {
        emailInput.setValue(email);
        return this;
    }

    @Step("fill mobile number Value:{0}")
    public RegistrationPageSteps mobileNumberField(String number) {
        mobileNumber.setValue(number);
        return this;
    }

    @Step("fill password Value:{0}")
    public RegistrationPageSteps passwordField(String pass) {
        passwordInput.setValue(pass);
        return this;
    }

    @Step("repeat correct Password Value:{0}")
    public RegistrationPageSteps repeatPasswordField(String name) {
        repeatPassword.setValue(name);
        return this;

    }

    @Step("repeat Incorrect Password Value:{0}")
    public RegistrationPageSteps repeatPasswordInCorr(String name) {
        repeatPasswordIncorrect.setValue(name);
        return this;

    }

    @Step("click create Account Button")
    public RegistrationPageSteps goToCreateAccount() {
        createAccountButton.click();
        return this;
    }


}
