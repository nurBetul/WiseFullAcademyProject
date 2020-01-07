package org.wisefull.tests;

import org.testng.annotations.Test;
import org.wisefull.pages.PurchasePage;

public class PurchasePageTests {
    PurchasePage purchasePage = new PurchasePage();
    @Test
    public void verifyIfCartIsEmpty(){
        purchasePage.controlIsCartEmpty();
    }
    @Test
    public void verifyIfCanBuyACourse() throws InterruptedException {
        purchasePage.buyCourse();
    }
    @Test
    public void verifyIfCanCheckOut() throws InterruptedException {
        purchasePage.checkOut();
    }
}
