package testsuite;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utils.Utility;

public class LoginTest extends Utility {
    String baseurl = "https://parabank.parasoft.com/parabank/index.htm";

    @Before
    public void setup() {
        openBrowser(baseurl);
    }

    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials() throws InterruptedException {
        sendTextToElement(By.id("username"), "utislatep@gmail.com");
        sendTextToElement(By.name("Password"), "Msm_23");
        clickOnElement(By.xpath("//button[contains(text(),'Log in')]"));
        String actualText = getTextFromElement(By.className("Accounts Overview"));
        String expectedText = "Accounts Overview";
        Assert.assertEquals(expectedText, actualText);
    }

    @Test
    public void verifyTheErrorMessage() throws InterruptedException {
        sendTextToElement(By.id("username"), "utilatep@gmail.com");
        sendTextToElement(By.name("Password"), "Msm23");
        clickOnElement(By.xpath("//button[contains(text(),'Log in')]"));
        String actualText = getTextFromElement(By.className("The username and password could not be verified."));
        String expectedText = "The username and password could not be verified.";
        Assert.assertEquals(expectedText, actualText);

    }
    @Test
    public void userShouldLogOutSuccessfully() throws InterruptedException {
        sendTextToElement(By.id("username"), "utislatep@gmail.com");
        sendTextToElement(By.name("Password"), "Msm_23");
        clickOnElement(By.xpath("//button[contains(text(),'Log in')]"));
        clickOnElement(By.className("Log Out"));
        String actualText = getTextFromElement(By.className("‘Customer Login’"));
        String expectedText = "‘Customer Login’";
        Assert.assertEquals(expectedText, actualText);
    }

}

