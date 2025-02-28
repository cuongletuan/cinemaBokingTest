package scripts;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.HomePage;
import pages.LoginPage;
import pages.ProfilePage;
import pages.PurchasePage;

import java.time.Duration;

public class cinemaBookingFromTabBar {

    static WebDriver driver;

    public static void main(String [] arg){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://demo1.cybersoft.edu.vn/");

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("lvc","123456");

        HomePage homePage = new HomePage(driver);
        homePage.selectSlotTab();

        PurchasePage purchasePage = new PurchasePage(driver);
        purchasePage.bookingManySlot(new String[]{"18", "19"});

        ProfilePage profilePage = new ProfilePage(driver);
        profilePage.verifyBookingPriceAndName("120000", "Bloodshot 1");
    }
}
