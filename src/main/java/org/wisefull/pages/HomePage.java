package org.wisefull.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.wisefull.common.Driver;
import org.wisefull.common.PageBase;
import java.util.List;


public class HomePage extends PageBase {
    private static WebDriver driver = Driver.getDriver();
    private static By listOfSlidingPic = By.xpath("//rs-slide[contains(@data-key, 'rs')]");
    private static By pictureRightArrow = By.cssSelector("rs-arrow.tp-rightarrow.tparrows.uranus");
    private static By pictureLeftArrow =By.cssSelector("rs-arrow.tp-leftarrow.tparrows.uranus");
    List<WebElement> myGallery = seleniumUtil.findElements(listOfSlidingPic);


        public void goHomePage(){
            driver.get(seleniumUtil.getProperty("homePageUrl"));
            seleniumUtil.implicitlyWait();
            driver.manage().window().maximize();
        }
        public void clickRightArrow() throws InterruptedException {
            goHomePage();
            seleniumUtil.explicitWait(pictureRightArrow);
            myGallery = seleniumUtil.findElements(listOfSlidingPic);
            for (WebElement image: myGallery
            ) {
                seleniumUtil.explicitWait(image);
                seleniumUtil.click(pictureRightArrow);
                seleniumUtil.assertIsDisplayed(image);
                //System.out.println("1. "+ image + "is displayed");
            }

        }
        public void clickLeftArrow() throws InterruptedException {
            goHomePage();
            myGallery = seleniumUtil.findElements(listOfSlidingPic);
            seleniumUtil.explicitWait(pictureLeftArrow);
            for (WebElement image: myGallery
            ) {
                seleniumUtil.explicitWait(image);
                seleniumUtil.click(pictureLeftArrow);
                seleniumUtil.assertIsDisplayed(image);
                System.out.println("1. "+ image + "is displayed");
            }
        }

        public void slidingPicturesTest() throws InterruptedException {
            goHomePage();
            List<WebElement> myGallery = seleniumUtil.findElements(listOfSlidingPic);
            for (WebElement image: myGallery
                 ) {
                seleniumUtil.explicitWait(image);
                seleniumUtil.assertIsDisplayed(image);
                System.out.println("1. "+ image + "is displayed");
            }
        }

    public void waitForPageToLoad() {
        seleniumUtil.waitForPageLoaded();
    }
}






