package tests;

import dto.Customer;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CheckOutTest extends BaseTest{
    @Test
    public void checkoutTest(){
        Customer customer = new Customer("Alena", "Zhilina", "000000");
        loginPage.open()
                .login("standard_user", "secret_sauce")
                .addToCart("Sauce Labs Bolt T-Shirt")
                .addToCart("Sauce Labs Onesie")
                .clickToCart()
                .clickCheckoutButton()
                .writeInfo(customer)
                .clickContinue()
                .clickFinish();
        assertEquals(completePage.getFinishMessage(), "Thank you for your order!");


//        loginPage.open();
//        loginPage.login("standard_user", "secret_sauce");
//        productsPage.addToCart("Sauce Labs Bolt T-Shirt");
//        productsPage.addToCart("Sauce Labs Onesie");
//        productsPage.clickToCart();
//        cartPage.clickCheckoutButton();
//        checkoutInfo.writeInfo("Alena", "Zhilina", "000000");
//        checkoutInfo.clickContinue();
//        overviewPage.clickFinish();
//        Assert.assertEquals(completePage.getFinishMessage(), "Thank you for your order!");

    }
}
