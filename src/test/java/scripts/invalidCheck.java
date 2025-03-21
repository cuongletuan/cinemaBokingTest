package scripts;

import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import pages.LoginPage;

public class invalidCheck extends baseTest{

    @Test
    public void verifyInputText(){

        driver.findElement(By.xpath("//a[@href='/sign-in']")).click();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.inputUser("lvc");
        loginPage.inputPassword("");
        loginPage.loginButton();

    }
    @AfterMethod
    public void quit(){
        driver.quit();
    }
}
