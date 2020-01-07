package org.wisefull.pages;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.wisefull.common.PageBase;
import org.wisefull.utils.ConfigReader;

public class PurchasePage extends PageBase {

    private static By cartButton = By.cssSelector("span.eltdf-cart-icon.icon_bag_alt");
    private static By emptyCartAutomaticDropdown = By.cssSelector("li.eltdf-empty-cart>p");
    private static By buyCourseButton = By.xpath("//span[contains(text(),'Buy Course' )]");
    private static By viewCartButton = By.cssSelector("span.eltdf-btn-text");
    private static By cartAutomaticDropdownAfterPurchase = By.cssSelector("div.eltdf-shopping-cart-dropdown");
    private static By checkoutButtonOnAutomaticDropdown = By.cssSelector("a.eltdf-view-checkout");
    private static By firstNameTextBox = By.cssSelector(" [id='billing_first_name']");
    private static By lastNameTextBox = By.cssSelector("input#billing_last_name");
    private static By countryButton = By.cssSelector("span#select2-billing_country-container");
    private static By countryButtonTextBox = By.cssSelector("input.select2-search__field");
    private static By streetAddressTextBox1 = By.cssSelector("input#billing_address_1");
    private static By streetAddressTextBox2 = By.cssSelector("input#billing_address_2");
    private static By postCodeTextBox = By.cssSelector("input#billing_postcode");
    private static By stateClickButton = By.cssSelector("span#select2-billing_state-container");
    private static By stateTextBox = By.cssSelector("input.select2-search__field");
    private static By cityTextBox = By.cssSelector("input#billing_city");
    private static By phoneTextBox =By.cssSelector("input#billing_phone");
    private static By emailTextBox = By.cssSelector("input#billing_email");
    private static By billingForm = By.cssSelector("form.checkout.woocommerce-checkout");
    private static By placeOrderButton = By.cssSelector("button#place_order");
    private static By invalidPaymentError = By.cssSelector("ul.woocommerce-error");



    public void goBusinessCoachingPage(){
        seleniumUtil.goToPage(ConfigReader.getProperty("businessCoachingPageUrl"));
        seleniumUtil.maximizePage();
    }
    public void controlIsCartEmpty(){
        goBusinessCoachingPage();
        seleniumUtil.moveToElement(seleniumUtil.findElement(cartButton));
        seleniumUtil.explicitWait(emptyCartAutomaticDropdown);
        Assert.assertEquals(seleniumUtil.getText(emptyCartAutomaticDropdown), "No products in the cart.");
    }

    public void buyCourse() throws InterruptedException {
       goBusinessCoachingPage();
       seleniumUtil.click(buyCourseButton);
       String actual = seleniumUtil.getText(viewCartButton);
       //System.out.println(actual);
       Assert.assertEquals(actual, "VIEW CART");
       seleniumUtil.moveToElement(seleniumUtil.findElement(cartButton));
       seleniumUtil.explicitWait(cartAutomaticDropdownAfterPurchase);
       String actualResult = seleniumUtil.getText(cartAutomaticDropdownAfterPurchase);
       //System.out.println(actualResult);
       Assert.assertEquals(actualResult, "Business Coaching\n" +
               "Quantity: 1 x $1,500.00\n" +
               "Total: $1,500.00\n" +
               "VIEW CART\n" +
               "CHECKOUT");
    }

    public void checkOut() throws InterruptedException {
        buyCourse();

        seleniumUtil.implicitlyWait();
        seleniumUtil.click(checkoutButtonOnAutomaticDropdown);
        seleniumUtil.explicitWait(billingForm);
        seleniumUtil.isClickable(firstNameTextBox);
        seleniumUtil.click(firstNameTextBox);
        seleniumUtil.sendKeys(firstNameTextBox , ConfigReader.getProperty("firstName"));
        seleniumUtil.isClickable(lastNameTextBox);
        seleniumUtil.click(lastNameTextBox);
        seleniumUtil.sendKeys(lastNameTextBox , ConfigReader.getProperty("lastName"));
        seleniumUtil.isClickable(countryButton);
        seleniumUtil.click(countryButton);
        seleniumUtil.click(countryButtonTextBox);
        seleniumUtil.sendKeys(countryButtonTextBox, ConfigReader.getProperty("country"));
        seleniumUtil.isClickable(streetAddressTextBox1);
        seleniumUtil.click(streetAddressTextBox1);
        seleniumUtil.sendKeys(streetAddressTextBox1 , ConfigReader.getProperty("street1"));
        seleniumUtil.isClickable(streetAddressTextBox2);
        seleniumUtil.click(streetAddressTextBox2);
        seleniumUtil.sendKeys(streetAddressTextBox2 , ConfigReader.getProperty("street2"));
        seleniumUtil.isClickable(postCodeTextBox);
        seleniumUtil.click(postCodeTextBox);
        seleniumUtil.sendKeys(postCodeTextBox, ConfigReader.getProperty("postCode"));
        seleniumUtil.isClickable(stateClickButton);
        seleniumUtil.click(stateClickButton);
        seleniumUtil.isClickable(stateTextBox);
        seleniumUtil.click(stateTextBox);
        seleniumUtil.sendKeys(stateTextBox, ConfigReader.getProperty("state"));
        seleniumUtil.clickEnter(stateTextBox);
        seleniumUtil.isClickable(cityTextBox);
        seleniumUtil.click(cityTextBox);
        seleniumUtil.sendKeys(cityTextBox, ConfigReader.getProperty("city"));
        seleniumUtil.isClickable(phoneTextBox);
        seleniumUtil.click(phoneTextBox);
        seleniumUtil.sendKeys(phoneTextBox, ConfigReader.getProperty("phone"));
        seleniumUtil.isClickable(emailTextBox);
        seleniumUtil.click(emailTextBox);
        seleniumUtil.sendKeys(emailTextBox, ConfigReader.getProperty("email"));
        try{
        seleniumUtil.isClickable(placeOrderButton);
        seleniumUtil.click(placeOrderButton);
        seleniumUtil.explicitWait(invalidPaymentError);

        } catch (Exception e){
            seleniumUtil.isClickable(placeOrderButton);
            seleniumUtil.click(placeOrderButton);
        }
        seleniumUtil.assertIsDisplayed(invalidPaymentError);

    }

    public void waitForPageToLoad() {
        seleniumUtil.waitForPageLoaded();
    }
}
