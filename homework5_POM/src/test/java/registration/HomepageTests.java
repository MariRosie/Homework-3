package registration;

import org.testng.Assert;
import org.testng.annotations.Test;
import stepObject.HomepageSteps;
import utils.ChromeRunner;

import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selenide.$;
import static dataObject.HomepageData.*;

public class HomepageTests extends ChromeRunner {
HomepageSteps homepageSteps = new HomepageSteps();

@Test
 public void itemInCartCase(){
  homepageSteps
          .fillSearchField(searchValue)
          .clickSearchButton()
          .selectItemElisabeth()
          .addToCartItem()
          .seeNumber()
          .goToMyCart();

Assert.assertEquals($(byName("qty")).getValue(),"1");
}


}
