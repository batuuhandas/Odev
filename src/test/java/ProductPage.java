import com.thoughtworks.gauge.Step;
import io.appium.java_client.MobileElement;
import org.junit.Assert;
import org.openqa.selenium.By;
import java.util.List;
import java.util.Random;

public class ProductPage extends BaseTest{

    @Step("Xpathli <xpath> in texti alinir ve kontrol edilir")
    public void getTextWithXpath(String xpath){
        MobileElement element = appiumDriver.findElement(By.xpath(xpath));
        System.out.println(element.getText());
        Assert.assertTrue("Kot sayfasında değilsiniz",isDisplayed(xpath));
    }
    @Step("<xpath> li element gorunur mu")
    public boolean isDisplayed(String xpath) {
        return appiumDriver.findElement(By.xpath(xpath)).isDisplayed();
    }


    @Step("<random> ürün seçilir")
    public void randomProductClick(String random){
        List<MobileElement> elements = appiumDriver.findElementsById(random);
        Random random1 = new Random();
        int randomInt = random1.nextInt(elements.size());
        elements.get(randomInt).click();
    }


}
