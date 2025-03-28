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

public class cinemaBookingVerticalTabFromHome extends baseTest {

    @Test
    public void verifyBookingVerticalTabFromHome() {

        driver.findElement(By.xpath("//a[@href='/sign-in']")).click();

        LoginPage loginPage = new LoginPage(driver);

        loginPage.inputUser("lvc");
        loginPage.inputPassword("123456");
        loginPage.loginButton();

        Actions actions = new Actions(driver);

        WebElement scrollTab = driver.findElement(By.xpath("//div[@id='cumRap']"));
        actions.scrollToElement(scrollTab).perform();

        HomePage homePage = new HomePage(driver);
        homePage.selectSlotVerticalTab("cinestar", "CNS - Quốc Thanh","Bloodshot 1", "10-12-2021");

        PurchasePage purchasePage = new PurchasePage(driver);
        purchasePage.bookingManySlot(new String[]{"18", "19"});

        ProfilePage profilePage = new ProfilePage(driver);
        profilePage.verifyBookingPriceAndName("120000", "Bloodshot 1");
    }
    @AfterMethod
    public void quit(){
        driver.quit();
    }
}
