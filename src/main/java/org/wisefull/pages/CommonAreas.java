package org.wisefull.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.wisefull.common.Driver;
import org.wisefull.common.PageBase;
import org.wisefull.utils.ConfigReader;

public class CommonAreas extends PageBase {

        private static By magnifyingGlassIconLocator = By.cssSelector("a.eltdf-search-opener.eltdf-icon-has-hover>span");
        private static By searchBoxLocator = By.cssSelector("form.eltdf-search-cover.eltdf-is-active");
        private static By academicCoachingFieldInAllCourses = By.xpath("//div[@class='eltdf-cl-inner eltdf-outer-space  clearfix']/article//a[contains(@href,'academic-coaching-aida-zhanyshbekova')]");
        private static By academicCoachingPageBanner = By.cssSelector("div.eltdf-title-inner");
        private static By worldMapMediaImage = By.cssSelector("div#media_image-3");
        HomePage homePage = new HomePage();

    public void clickMagnifyingGlass() throws InterruptedException {
        homePage.goHomePage();
        seleniumUtil.implicitlyWait();
        seleniumUtil.click(magnifyingGlassIconLocator);
        seleniumUtil.assertIsDisplayed(searchBoxLocator);
    }
    public void scrollDownClickWorldMapImage() throws InterruptedException {
        homePage.goHomePage();
        seleniumUtil.scrollByVisibleElement(worldMapMediaImage);
        seleniumUtil.getThread(4000);
        seleniumUtil.click(worldMapMediaImage);
    }
    public void navigateAcademicCoachingPage() throws InterruptedException {
        seleniumUtil.implicitlyWait();
        scrollDownClickWorldMapImage();
        seleniumUtil.scrollByVisibleElement(academicCoachingFieldInAllCourses);
        seleniumUtil.isClickable(academicCoachingFieldInAllCourses);
        seleniumUtil.click(academicCoachingFieldInAllCourses);
        seleniumUtil.explicitWait(academicCoachingPageBanner);
        Assert.assertEquals(ConfigReader.getProperty("academicCoachingPageUrl"), seleniumUtil.getCurrentUrl());
    }

    public void waitForPageToLoad() {
        seleniumUtil.waitForPageLoaded();
    }
}
