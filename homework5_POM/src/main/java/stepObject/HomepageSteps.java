package stepObject;

import io.qameta.allure.Step;
import pageObject.HomePage;

public class HomepageSteps extends HomePage {
    @Step("Fill Search Field with Value:{0}")
    public HomepageSteps fillSearchField(String item){
        searchField.setValue(item);
        return this;
    }
    @Step("click Search Button to get results")
    public HomepageSteps clickSearchButton(){
        searchButton.click();
        return this;
    }
    @Step("select item and click")
    public HomepageSteps selectItemElisabeth() {
        selectItem.click();
        return this;
    }
    @Step("click add to cart")
    public HomepageSteps addToCartItem(){
        addToCartButton.click();
        return this;
    }
    @Step("click cart and see if choosen item is there")
    public HomepageSteps goToMyCart(){
        cartButton.click();
        return this;
    }
    @Step("click cart and see if choosen item is there")
    public HomepageSteps seeNumber(){
        itemNumberInCart.exists();
        return this;
    }





}
