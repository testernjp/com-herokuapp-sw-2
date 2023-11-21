package browserfactory.testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

public class LoginTest extends BaseTest {
    String baseURL = "http://the-internet.herokuapp.com/login";

    @Before
    public void setup() {
        openBrowser(baseURL);
    }

    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials() {
        // Find username and enter credentials
        driver.findElement(By.name("username")).sendKeys("tomsmith");
        // Find password field and enter credentials
        driver.findElement(By.name("password")).sendKeys("SuperSecretPassword!");
        // Find and click on login button
        driver.findElement(By.xpath("//i")).click();
        // Verify the text secure area
        String expectedText = "Secure Area";
        String actualText = driver.findElement(By.xpath("//h2[normalize-space()='Secure Area']")).getText();
        Assert.assertEquals(expectedText, actualText);
    }

    @Test
    public void verifyTheUsernameErrorMessage() {
        // Find username and enter credentials
        driver.findElement(By.name("username")).sendKeys("tomsmith1");
        // Find password field and enter credentials
        driver.findElement(By.name("password")).sendKeys("SuperSecretPassword!");
        // Find and click on login button
        driver.findElement(By.xpath("//i")).click();
        // Verify the text error message
        String expectedText = "Your username is invalid!\n×";
        String actualText = driver.findElement(By.xpath("//div[@id='flash']")).getText();
        Assert.assertEquals(expectedText, actualText);
    }

    @Test
    public void verifyThePasswordErrorMessage() {
        // Find username and enter credentials
        driver.findElement(By.name("username")).sendKeys("tomsmith");
        // Find password field and enter credentials
        driver.findElement(By.name("password")).sendKeys("SuperSecretPassword");
        // Find and click on login button
        driver.findElement(By.xpath("//i")).click();
        // Verify the text error message
        String expectedText = "Your password is invalid!\n×";
        String actualText = driver.findElement(By.xpath("//div[@id='flash']")).getText();
        Assert.assertEquals(expectedText, actualText);
    }

    @After
    public void tearDown() {
        closeBrowser();
    }
}
