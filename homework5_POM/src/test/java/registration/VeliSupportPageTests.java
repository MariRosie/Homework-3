package registration;

import com.codeborne.selenide.Condition;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import stepObject.VelisupportPageSteps;
import utils.ChromeRunner;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.sleep;
import static dataObject.VeliSupportPageData.maxPrice;
import static dataObject.VeliSupportPageData.minPrice;

public class VeliSupportPageTests extends ChromeRunner {
    VelisupportPageSteps velisupportPageSteps = new VelisupportPageSteps();

    @Test
    public  void supportSortByPriceCase(){
        velisupportPageSteps
                .goToVeliSupport()
                .clickChevron()
                .fillMinPrice(minPrice)
                .fillMaxPrice(maxPrice)
                .clickOkButton()
                .clickSortByPrice()
                .checkFirstPrice();


        SoftAssert softAssertName = new SoftAssert();
        softAssertName.assertEquals(velisupportPageSteps.firstItemPrice.getText(),"10.00","დასორტირებული პროდუქტების პირველი პროდუქტის ფასი უნდა იყოს ჩვენი მითითებული მინიმალური");
        softAssertName.assertAll();

    }





}
