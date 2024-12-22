import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;


public class LoginTest extends BaseTest{


    @Test
    public void checkNegativeLoginWithEmptyUsername() {

        driver.findElement(By.id("user-name")).sendKeys("");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        String errorMessage = driver.findElement(By.cssSelector("[data-test=error]")).getText();
        Assert.assertEquals(errorMessage, "Epic sadface: Username is required");

    }

    @Test
    public void checkNegativeLoginWithEmptyPassword() {

        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("");
        driver.findElement(By.id("login-button")).click();
        String errorMessage = driver.findElement(By.cssSelector("[data-test=error]")).getText();
        Assert.assertEquals(errorMessage, "Epic sadface: Password is required");

    }

    @Test
    public void checkNegativeLoginWithWrongPassword() {

        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("123");
        driver.findElement(By.id("login-button")).click();
        String errorMessage = driver.findElement(By.cssSelector("[data-test=error]")).getText();
        Assert.assertEquals(errorMessage, "Epic sadface: Username and password do not match any user in this service");

    }

    @Test
    public void checkPositiveLogin() {

        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        Boolean isDisplayed = driver.findElement(By.cssSelector("[data-test=title]")).isDisplayed();
        Assert.assertTrue(isDisplayed);
//        String title = driver.findElement(By.cssSelector("[data-test=title]")).getText();
//        Assert.assertEquals(title, "Products");

    }

}
