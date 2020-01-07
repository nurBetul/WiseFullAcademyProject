package org.wisefull.tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import org.wisefull.common.TestBase;
import org.wisefull.pages.HomePage;

public class HomePageTests extends TestBase {
    HomePage homePage = new HomePage();

    @Test
    public void verifyIfNavigateHomePage(){
        homePage.goHomePage();
    }
    @Test
    public void verifyIfClicksRightArrowForSlidingPic() throws InterruptedException {
        homePage.clickRightArrow();
    }
    @Test
    public void verifyIfClicksLeftArrowForSlidingPic() throws InterruptedException {
        homePage.clickLeftArrow();
    }
    @Test
    public void verifyTheSlidingPictures() throws InterruptedException {
        homePage.slidingPicturesTest();
    }





}
