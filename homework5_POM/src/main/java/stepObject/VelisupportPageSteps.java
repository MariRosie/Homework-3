package stepObject;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import pageObject.VeliSupportPage;

import java.time.Duration;

public class VelisupportPageSteps extends VeliSupportPage {

    @Step("Click Veli of Support Category")
    public VelisupportPageSteps goToVeliSupport() {
        veliOfSupportButton.shouldBe(Condition.visible, Duration.ofMillis(4000));
        veliOfSupportButton.click();
        return this;
    }

    @Step("click Chevron to see Price")
    public VelisupportPageSteps clickChevron() {
        chevronDown.shouldBe(Condition.visible, Duration.ofMillis(4000));
        chevronDown.click();
        return this;
    }
    @Step("fill min Price Value: {0}")
    public VelisupportPageSteps fillMinPrice(String minPr) {
        minPriceField.setValue(minPr);
        return this;
    }
    @Step("fill max Price Value: {0}")
    public VelisupportPageSteps fillMaxPrice(String maxPr) {
        maxPriceField.setValue(maxPr);
        return this;
    }
    @Step("click OK button to see Products")
    public VelisupportPageSteps clickOkButton() {
        okButton.click();
        return this;
    }
    @Step("click Sort By Price")
    public VelisupportPageSteps clickSortByPrice() {
        sortByPrice.shouldBe(Condition.visible, Duration.ofMillis(4000));
        sortByPrice.click();
        return this;
    }
    @Step("check first Item Price")
    public VelisupportPageSteps checkFirstPrice() {
        firstItemPrice.doubleClick();
        return this;
    }
}
