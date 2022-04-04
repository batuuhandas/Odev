import com.thoughtworks.gauge.Step;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;

import java.time.Duration;

public class BasePage extends BaseTest{
    @Step("<s> saniye kadar bekle")
    public void waitForsecond(int s) throws InterruptedException {
        Thread.sleep(1000*s);
    }

    @Step("Xpathli <xpath> elemetin sayfada gorunur olduğunu kontrol et ve tıkla")
    public void findByelementWithXpathAndClick(String xpath){
        MobileElement element = appiumDriver.findElement(By.xpath(xpath));
        if (element.isDisplayed()){
            System.out.println("Kontrol edilen element gorunur.");
            element.click();
        }else{
            System.out.println("Kontrol edilen element gorunur olmadı");
        }
    }
    @Step("Id li <id> elemetin sayfada gorunur olduğunu kontrol et ve tıkla")
    public void findByelementWithIdAndClick(String id){
        MobileElement element = appiumDriver.findElement(By.id(id));
        if (element.isDisplayed()){
            System.out.println("Kontrol edilen element gorunur.");
            element.click();
        }else{
            System.out.println("Kontrol edilen element gorunur olmadı");
        }
    }

    @Step("Xpath <xpath> li elementi bul ve tikla")
    public void clickByxpath(String xpath){
        appiumDriver.findElement(By.xpath(xpath)).click();
    }

    @Step("Sayfayı aşağı doğru kaydır")
    public void swipeUp(){
        final int ANIMATION_TIME = 200; // ms
        final int PRESS_TIME = 200; // ms
        int edgeBorder = 10; // better avoid edges
        PointOption pointOptionStart, pointOptionEnd;
        // init screen variables
        Dimension dims = appiumDriver.manage().window().getSize();
        System.out.println("Telefon Ekran Boyutu " + dims);
        // init start point = center of screen
        pointOptionStart = PointOption.point(dims.width / 2, dims.height / 2);
        System.out.println("Başlangıç noktası " + pointOptionStart);
        pointOptionEnd = PointOption.point(dims.width / 2, dims.height / 4);
        System.out.println("Bitiş noktası " + pointOptionEnd);
        try {
            new TouchAction(appiumDriver)
                    .press(pointOptionStart)
                    // a bit more reliable when we add small wait
                    .waitAction(WaitOptions.waitOptions(Duration.ofMillis(PRESS_TIME)))
                    .moveTo(pointOptionEnd)
                    .release().perform();
        } catch (Exception e) {
            System.err.println("swipeScreen(): TouchAction FAILED\n" + e.getMessage());
            return;
        }

        // always allow swipe action to complete
        try {
            Thread.sleep(ANIMATION_TIME);
        } catch (InterruptedException e) {
            // ignore
        }
    }@Step("Sayfayı aşağı doğru 2 kez kaydır")
    public void swipeUptwice(){
        final int ANIMATION_TIME = 200; // ms
        final int PRESS_TIME = 200; // ms
        int edgeBorder = 10; // better avoid edges
        PointOption pointOptionStart, pointOptionEnd;
        // init screen variables
        Dimension dims = appiumDriver.manage().window().getSize();
        System.out.println("Telefon Ekran Boyutu " + dims);
        // init start point = center of screen
        pointOptionStart = PointOption.point(dims.width / 2, dims.height / 2);
        System.out.println("Başlangıç noktası " + pointOptionStart);
        pointOptionEnd = PointOption.point(dims.width / 2, dims.height / 4);
        System.out.println("Bitiş noktası " + pointOptionEnd);pointOptionStart = PointOption.point(dims.width / 2, dims.height / 2);
        try {
            new TouchAction(appiumDriver)
                    .press(pointOptionStart)
                    // a bit more reliable when we add small wait
                    .waitAction(WaitOptions.waitOptions(Duration.ofMillis(PRESS_TIME)))
                    .moveTo(pointOptionEnd)
                    .release().perform()
                    .press(pointOptionStart)
                    // a bit more reliable when we add small wait
                    .waitAction(WaitOptions.waitOptions(Duration.ofMillis(PRESS_TIME)))
                    .moveTo(pointOptionEnd)
                    .release().perform();
        } catch (Exception e) {
            System.err.println("swipeScreen(): TouchAction FAILED\n" + e.getMessage());
            return;
        }

        // always allow swipe action to complete
        try {
            Thread.sleep(ANIMATION_TIME);
        } catch (InterruptedException e) {
            // ignore
        }
    }
}


