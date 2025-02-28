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

public class cinemaBookingVerticalTabFromHome {

    static WebDriver driver;

    public static void main(String [] arg) {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://demo1.cybersoft.edu.vn/");

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("lvc","123456");

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
}
