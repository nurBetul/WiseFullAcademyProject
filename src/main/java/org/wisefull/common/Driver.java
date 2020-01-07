package org.wisefull.common;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Driver {
    public static WebDriver driver;
    public static WebDriver getDriver(){
        if(driver == null){
            setUpDriver();
        }
        return driver;
    }

    public static void setUpDriver(){
        if(driver==null) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        }
    }

    public static void closeDriver(){
        if(driver != null){
            driver.quit();
          //  driver.close();
            driver=null;
        }
    }

}
