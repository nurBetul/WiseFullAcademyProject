package org.wisefull.pages;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.wisefull.common.Driver;
import org.wisefull.common.PageBase;

public class LoginPage extends PageBase {

    private static By contactUsLocator = By.xpath("//li[@id='nav-menu-item-4507']//span[contains(text(),'Contact Us')]");
    private static By loginLocator = By.xpath("//li[@id='nav-menu-item-6334']//span[contains(text(),'Login')]");
    private static By secondLoginLocator = By.cssSelector("button#btn-login");
    private static By userNameLocator = By.cssSelector("input[name='username']");
    private static By passwordLocator = By.cssSelector("input[name='password']");
    private static By loginButtonLocator = By.cssSelector("button.md-raised.md-accent.submit-button.md-button.md-teal-theme.md-ink-ripple");
    private static By nameInLoginPageLocator = By.cssSelector("username hide-md hide-sm hide-xs ng-binding");
    private static By welcomeLoginPageName = By.cssSelector("div#dashboard-user span.font-size-16.ng-binding");
    private String loginPageUrl = "https://lessoncourse.com/dashboard-user";
    private By invalidCredentialsAlertButton = By.cssSelector("button.md-icon-button.md-button.md-ink-ripple");
    private By invalidPasswordAlertField = By.xpath("//md-toast/div");
    private By inactiveLoginButton = By.cssSelector("button[type='submit'] span[class='ng-scope']");
    HomePage homePage = new HomePage();

    public void goLoginPage(){
        homePage.goHomePage();
        seleniumUtil.click(contactUsLocator);
        seleniumUtil.explicitWait(loginLocator);
        seleniumUtil.click(loginLocator);
    }

    public void loginSuccessfully(String username, String password) throws InterruptedException {
        goLoginPage();
        seleniumUtil.implicitlyWait();
        seleniumUtil.click(secondLoginLocator);
        seleniumUtil.sendKeys(userNameLocator, username);
        seleniumUtil.click(passwordLocator);
        seleniumUtil.sendKeys(passwordLocator, password);
        seleniumUtil.click(loginButtonLocator);
        seleniumUtil.explicitWait(welcomeLoginPageName);
        Assert.assertEquals(loginPageUrl, seleniumUtil.getCurrentUrl());
    }
    public void loginWithWrongPasswordTrueUsername(String username, String password){
        goLoginPage();
        seleniumUtil.implicitlyWait();
        seleniumUtil.click(secondLoginLocator);
        seleniumUtil.sendKeys(userNameLocator, username);
        seleniumUtil.click(passwordLocator);
        seleniumUtil.sendKeys(passwordLocator, password);
        seleniumUtil.click(loginButtonLocator);
        seleniumUtil.explicitWait(invalidPasswordAlertField);
        Assert.assertEquals(seleniumUtil.getText(invalidPasswordAlertField), "Invalid password.");
    }
    public void loginWithTruePasswordWrongUsername(String password, String username){
        goLoginPage();
        seleniumUtil.implicitlyWait();
        seleniumUtil.click(secondLoginLocator);
        seleniumUtil.sendKeys(userNameLocator, username);
        seleniumUtil.click(passwordLocator);
        seleniumUtil.sendKeys(passwordLocator, password);
        seleniumUtil.click(loginButtonLocator);
        seleniumUtil.explicitWait(invalidPasswordAlertField);
        Assert.assertEquals(seleniumUtil.getText(invalidPasswordAlertField), "User not found.");
    }

    public void isLoginButtonInactiveWithoutCredentials(){
        goLoginPage();
        seleniumUtil.implicitlyWait();
        seleniumUtil.click(secondLoginLocator);
        Assert.assertFalse(seleniumUtil.isClickable(inactiveLoginButton));
    }


    public void waitForPageToLoad() {
        seleniumUtil.waitForPageLoaded();
    }
}
