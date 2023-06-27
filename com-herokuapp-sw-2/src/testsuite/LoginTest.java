package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

public class LoginTest extends BaseTest {
    String baseUrl="http://the-internet.herokuapp.com/login";
    @Before
    public void setup(){
        openBrowser(baseUrl);
    }
    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials(){
        driver.findElement(By.id("username")).sendKeys("tomsmith");
        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
        driver.findElement(By.xpath("//i[@class='fa fa-2x fa-sign-in']")).click();
        String actualText=driver.findElement(By.xpath("//h2[text()]")).getText();
        String expectedText="Secure Area";
        Assert.assertEquals("Secure area text not displayed",actualText,expectedText);

    }
    @Test
    public void verifyTheUserNameErrorMessage(){
        driver.findElement(By.id("username")).sendKeys("tomsmith1");
        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
        driver.findElement(By.xpath("//i[@class='fa fa-2x fa-sign-in']")).click();
        String actualText=driver.findElement(By.id("flash")).getText();
       System.out.println(actualText);
      String expectedText="Your username is invalid!\n" +
              "×";
       // Assert.assertEquals("Username is invalid text not displayed",actualText,expectedText);

    }@Test
    public void verifyThePasswordErrorMessage(){
        driver.findElement(By.id("username")).sendKeys("tomsmith1");
        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
        driver.findElement(By.xpath("//i[@class='fa fa-2x fa-sign-in']")).click();
        String actualText=driver.findElement(By.id("flash")).getText();
        System.out.println(actualText);
        String expectedText="Your username is invalid!\n" +
                "×";
        Assert.assertEquals("Username is invalid text not displayed",actualText,expectedText);
    }
    @After
    public void tearDown(){
        closeBrowser();
    }



}
