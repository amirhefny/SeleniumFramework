package Pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class MethodsHandle  {
    WebDriver driver;

    protected WebElement find(WebDriver driver, By locator){
        return driver.findElement(locator);
    }

    protected String getText(WebDriver driver, By locator) {
        return find(driver,locator).getText();
    }

    protected String getCssValue(WebDriver driver, By locator,String CssValue ) {
        return find(driver,locator).getCssValue(CssValue);
    }

    protected String getAttribute(WebDriver driver, By locator,String Attribute ) {
        return find(driver,locator).getAttribute(Attribute);
    }

    protected String getTagName(WebDriver driver, By locator) {
        return find(driver,locator).getTagName();
    }

    protected void click(WebDriver driver, By locator){
        find(driver, locator).click();
    }

    protected void clear(WebDriver driver, By locator){
        find(driver, locator).clear();
    }

    protected void fill(WebDriver driver, By locator, String value){
        find(driver, locator).clear();
        find(driver, locator).sendKeys(value);
    }
    protected void select(WebDriver driver, By locator, String selectBy, String selection){
        Select select = new Select
                (find(driver, locator));
        if(selectBy.equalsIgnoreCase("Value")){
            select.selectByValue(selection);}
        else if (selectBy.equalsIgnoreCase("Index")){
            select.selectByIndex(Integer.parseInt(selection));}
        else if (selectBy.equalsIgnoreCase("VisibleText")) {
            select.selectByVisibleText(selection);}
        wait(driver, 500);
    }

    protected void dragAndDrop(WebDriver driver, By firstLocator, By secondLocator){
        Actions actions = new Actions(driver);
        WebElement firstWebElement = find(driver, firstLocator);
        WebElement secondWebElement = find(driver, secondLocator);
        actions.clickAndHold(firstWebElement).pause(300).moveToElement(secondWebElement).pause(300).release().build().perform();
        wait(driver, 500);
    }

    protected Actions clickAndHold(WebDriver driver, By locator){
        Actions actions = new Actions(driver);
        WebElement webElement = find(driver, locator);
        return actions.clickAndHold(webElement);
    }
    protected void AcceptAlert() {
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }

    protected void RefuseAlert() {
        Alert alert = driver.switchTo().alert();
        alert.dismiss();
    }

    //prompt Alert
    protected void SendDataToAlert(String Data) {
        Alert alert = driver.switchTo().alert();
        alert.sendKeys(Data);
        alert.accept();
    }

    protected void switchToFrame(WebDriver driver, By frame){
        WebElement webElement = find(driver, frame);
        driver.switchTo().frame(webElement);
        //   Switch to the frame  By Index , By Name or Id , By Web Element
        driver.switchTo().defaultContent();
    }

    protected static WebDriver wait(WebDriver driver, int time){
        synchronized (driver) {
            try {
                driver.wait(time);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        return driver;
    }
}