package pageObject;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.*;

public class HomePage {
    public SelenideElement
    searchField = $(byXpath( "//*[@id=\"__next\"]/header/div[4]/div[1]/div[2]/form/input")),
    searchButton = $(".search-submit"),
    selectItem =$(byXpath("//*[@id=\"__next\"]/section/div/div[3]/div[4]/div[2]/a/span[1]/img")),
    addToCartButton = $("#cart-button-z"),
    itemNumberInCart =$(byName("qty")),
    cartButton =$("#cart-button");


}
