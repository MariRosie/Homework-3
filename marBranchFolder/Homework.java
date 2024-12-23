
import com.codeborne.selenide.SelenideElement;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

public class Homework {
    @Test
    public void fbcheck(){
        open("https://www.facebook.com/");
        SelenideElement createAccount = $(byTagAndText("a","Create new account"));
        createAccount.click();
        $(byName("firstname")).setValue("Mariam");
        $(byName("lastname")).setValue("Rosie");
        $(byName("reg_email__")).setValue("mariam@gmail.com");
        $("#password_step_input").setValue("mmmmmm");
        $(byName("birthday_month")).selectOption("May");
        $(byName("birthday_day")).selectOption("12");
        $(byName("birthday_year")).selectOption("1998");
        sleep(2000);
        SelenideElement customRadioButton = $(byText("Custom"));
        customRadioButton.click();
        sleep(1000);
        $("#preferred_pronoun").shouldBe(visible);
        $("#custom_gender").shouldBe(visible);
        $("#preferred_pronoun").selectOption("She: \"Wish her a happy birthday!\"");
        sleep(1000);
        SelenideElement femaleRadioButton = $(byText("Female"));
        femaleRadioButton.click();
        $("#preferred_pronoun").shouldBe(disappear);
        $("#custom_gender").shouldBe(disappear);
        sleep(1000);





    }

}
