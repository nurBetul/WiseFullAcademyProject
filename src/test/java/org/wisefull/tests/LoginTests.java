package org.wisefull.tests;

import org.testng.annotations.Test;
import org.wisefull.common.TestBase;
import org.wisefull.pages.LoginPage;


public class LoginTests extends TestBase {
    LoginPage loginPage = new LoginPage();

    @Test
    public void verifyGoLoginPage(){
        loginPage.goLoginPage();
    }

    @Test
    public void verifyLoginSuccessfully() throws InterruptedException {
        loginPage.loginSuccessfully("nyaz@na.edu ", "123456_point");
    }

    @Test
    public void verifyLoginWithWrongPasswordTrueUsername(){
        loginPage.loginWithWrongPasswordTrueUsername("mkortak@na.edu", "123456");
    }
    @Test
    public void verifyLoginWithTruePasswordWrongUsername(){
        loginPage.loginWithTruePasswordWrongUsername("nyaz@n.edu", "123456_point");
    }
    @Test
    public void verifyIfLoginButtonIsNotEnabledWithoutCredentials(){
        loginPage.isLoginButtonInactiveWithoutCredentials();
    }
}
