package testsuite;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utils.Utility;

public class RegisterTest extends Utility {
    String baseurl = "https://parabank.parasoft.com/parabank/index.htm";

    @Before
    public void setup() {
        openBrowser(baseurl);
    }

    @Test
    public void test1()  {
        clickOnElement(By.className("Register"));
        String actualMessage = getTextFromElement(By.xpath("//h1[contains(text(),' Register')]"));
        String expectedMessage = "Signing up is easy!";
        Assert.assertEquals("verifying Signing ", expectedMessage, actualMessage);
    }

    @Test
    public void userShouldRegisterAccountSuccessfully() throws InterruptedException {
        clickOnElement(By.className("Register"));
        sendTextToElement(By.id("First name"), "Jay");
        sendTextToElement(By.id("Last name"), "lepat");
        sendTextToElement(By.className("Adress"), "101 Laksh icon");
        sendKeysToElement(By.className("City"), "gujarat");
        sendKeysToElement(By.className("State"), "gujarat");
        sendKeysToElement(By.id("Zip Code"), "388250");
        sendKeysToElement(By.id("phone"), "07912345678");
        sendKeysToElement(By.id("SSN"), "123456");
        sendTextToElement(By.id("Username"), "utisletap@gmail.com");
        sendTextToElement(By.id("Password"), "Msm_23");
        sendTextToElement(By.id("Conform"), "Msm_23");
        clickOnElement(By.className("Register"));
        String actualMessage = getTextFromElement(By.xpath("//h1[contains(text(),' //Classname')]"));
        String expectedMessage = "Your account was created successfully. You are now logged in.";
        Assert.assertEquals("Your account was created successfully. You are now logged in.", expectedMessage, actualMessage);
    }
}











