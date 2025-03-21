package scripts;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.ProfilePage;
import pages.PurchasePage;

import java.time.Duration;

public class cinemaBookingFromHomePage extends baseTest {

    @Test
    public void verifyBookingFromHomepage(){


        driver.findElement(By.xpath("//a[@href='/sign-in']")).click();

        LoginPage loginPage = new LoginPage(driver);

        loginPage.inputUser("lvc");
        loginPage.inputPassword("123456");
        loginPage.loginButton();

        HomePage homePage = new HomePage(driver);
        homePage.selectSlotFromPanel("Raya","07-03-2022");

        PurchasePage purchasePage = new PurchasePage(driver);
        purchasePage.bookingSlot("6");

        ProfilePage profilePage = new ProfilePage(driver);
        profilePage.verifyBookingPrice("120000");
    }
    @AfterMethod
    public void quit(){
        driver.quit();
    }

}