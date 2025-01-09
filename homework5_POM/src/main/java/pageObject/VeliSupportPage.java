package pageObject;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.selector.*;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;

public class VeliSupportPage {
    public SelenideElement
            veliOfSupportButton = $(byTagAndText("h4", "მხარდაჭერის ველი")),
            chevronDown = $(byXpath("//*[@id=\"__next\"]/section/div/div[2]/div[2]/button")),
            minPriceField = $(byAttribute("placeholder", "მინ.")),
            maxPriceField = $(byAttribute("placeholder", "მაქს.")),
            okButton = $(byTagAndText("button", "ძებნა")),
            sortByPrice = $(byTagAndText("button", "ფასი")),
            firstItemPrice = $(byXpath("//*[@id=\"__next\"]/section/div/div[4]/div[4]/div[1]/div[1]/div/span"));


}
