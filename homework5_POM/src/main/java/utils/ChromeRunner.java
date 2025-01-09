package utils;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.testng.annotations.*;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class ChromeRunner {
    @BeforeTest(description = "configure browser before tests")
    public void setup() {
        open("https://veli.store/");
        //Configuration.headless = true; ვიზუალურად არ გაეშვება

    }
    @AfterTest(description = "clear cookies and close web driver")
    public void tearDown(){

        Selenide.clearBrowserCookies();
        Selenide.clearBrowserLocalStorage();
        Selenide.closeWindow();
        Selenide.closeWebDriver();
    }


}
