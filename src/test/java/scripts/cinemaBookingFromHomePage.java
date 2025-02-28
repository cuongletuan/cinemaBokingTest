package scripts;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import pages.HomePage;
import pages.LoginPage;
import pages.ProfilePage;
import pages.PurchasePage;

import java.time.Duration;

public class cinemaBookingFromHomePage {

    static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://demo1.cybersoft.edu.vn/");

        Actions actions = new Actions(driver);

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("lvc", "123456");

        HomePage homePage = new HomePage(driver);
        homePage.selectSlotFromPanel("Raya","07-03-2022");

        PurchasePage purchasePage = new PurchasePage(driver);
        purchasePage.bookingSlot("6");

        ProfilePage profilePage = new ProfilePage(driver);
        profilePage.verifyBookingPrice("120000");
    }


}