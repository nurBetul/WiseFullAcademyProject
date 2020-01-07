package org.wisefull.tests;

import org.testng.annotations.Test;
import org.wisefull.common.TestBase;
import org.wisefull.pages.CommonAreas;

public class CommonAreasTests extends TestBase {
    CommonAreas commonAreas = new CommonAreas();
    @Test
    public void verifyIfTheMagnifierGlassIsClickable() throws InterruptedException {
            commonAreas.clickMagnifyingGlass();
    }
    @Test
    public void verifyIfScrollsDownAndClicksWorldMapImage() throws InterruptedException {
        commonAreas.scrollDownClickWorldMapImage();
    }
    @Test
    public void verifyIfCanNavigateAcademicCoachingPage() throws InterruptedException {
        commonAreas.navigateAcademicCoachingPage();
    }
}
