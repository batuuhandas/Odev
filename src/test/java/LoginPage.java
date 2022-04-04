import com.thoughtworks.gauge.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;

public class LoginPage extends BaseTest{
    @Step("<xpathli> li elemente istenilen değer <text> yazılır")
    public void yaz(String xpath,String text){
        appiumDriver.findElement(By.xpath(xpath)).sendKeys(text);
    }
    @Step("<yaz> yazılır")
    public void yazdır(String text){
        Actions action = new Actions(appiumDriver);
        action.sendKeys(text).perform();
    }
    @Step("Klavye kapatılır")
    public void klavyeKapat(){
        appiumDriver.navigate().back();
        appiumDriver.navigate().back();
    }
    @Step("Geri gidilir")
    public void geriGit(){
        appiumDriver.navigate().back();
    }
}

