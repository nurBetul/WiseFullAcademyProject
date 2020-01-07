package org.wisefull.common;

import org.testng.annotations.*;

public class TestBase extends Base {

    @BeforeSuite
    public static void beforeSuite(){
       Driver.setUpDriver();
    }
    @AfterSuite
    public static void afterSuite(){

    }
    @BeforeMethod
    public static void beforeMethod(){
        Driver.getDriver();
    }
    @AfterMethod
    public static void afterMethod(){
        Driver.closeDriver();
    }



}
