package org.wisefull.utils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.wisefull.common.Driver;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class SeleniumUtil {
    WebDriver driver = Driver.getDriver();
    WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 20);
    Actions act = new Actions(Driver.getDriver());

    public void goToPage(String url){
        driver.get(url);
}
    public  WebElement findElement(By locator){
        return Driver.getDriver().findElement(locator);
    }
    public void sendKeys(By locator, String text){
        findElements(locator).clear();
        findElement(locator).sendKeys(text);
    }
    public void click(By locator){
        findElement(locator).click();
    }
    public void clickEnter(By locator){
        findElement(locator).sendKeys(Keys.ENTER);
    }
    public void assertIsDisplayed(By locator){
        Assert.assertTrue(findElement(locator).isDisplayed());
    }
    public void assertIsDisplayed(WebElement element){
       Assert.assertTrue(element.isDisplayed());
    }
    public void implicitlyWait(){
       driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }
    public List<WebElement> findElements(By locator){
       return driver.findElements(locator);
    }
    public String getAttribute(WebElement element, String text){
       return element.getAttribute(text);
    }
    public String getAttribute(By locator, String text){
        return driver.findElement(locator).getAttribute(text);
    }
    public void getThread(long mills) throws InterruptedException {
       Thread.sleep(mills);
    }
    public void explicitWait(By locator){
        wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
    public void explicitWait(WebElement element){
        wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(element));

    }

    public String getCurrentUrl(){
       return driver.getCurrentUrl();
    }
    public String getText(By locator){
       return findElement(locator).getText();
    }
    public boolean isClickable(By locator){
        try {
        wait.until(ExpectedConditions.elementToBeClickable(locator));
            return true;
        }
        catch (Exception e){
            return false;
        }
    }
    public boolean isClickable(WebElement element){
        try {
            wait.until(ExpectedConditions.elementToBeClickable(element));
            return true;
        }
        catch (Exception e){
            return false;
        }
    }

    public void scrollByVisibleElement(By locator){
       JavascriptExecutor js = ((JavascriptExecutor)driver);
       WebElement element = findElement(locator);
       js.executeScript("arguments[0].scrollIntoView();", element);

    }
    public String getProperty(String key){
      return ConfigReader.getProperty(key);
    }
    public void moveToElement(By locator){
        act.moveToElement(driver.findElement(locator)).build().perform();
    }
    public void moveToElement(WebElement element){
        act.moveToElement(element).build().perform();
    }
    public void maximizePage(){
        driver.manage().window().maximize();
    }

    public void waitForPageLoaded() {
        ExpectedCondition<Boolean> expectation = new ExpectedCondition<Boolean>()
                {
                    public Boolean apply(WebDriver driver) {
                        return ((JavascriptExecutor) driver).executeScript("return document.readyState").toString().equals("complete");
                    }
                };
        try {
            getThread(1000);
            wait = new WebDriverWait(driver, 30);
            wait.until(expectation);
        } catch (Throwable error) {
            Assert.fail("Timeout waiting for Page Load Request to complete.");
        }
    }

}

