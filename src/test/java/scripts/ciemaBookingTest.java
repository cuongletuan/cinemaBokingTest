package scripts;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import org.openqa.selenium.By;
import pages.LoginPage;
import pages.ProfilePage;
import pages.PurchasePage;

import java.time.Duration;

public class ciemaBookingTest {
    static WebDriver driver;

    public static void main(String [] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(10));
        driver.manage().window().maximize();

        driver.get("https://demo1.cybersoft.edu.vn/");

        Actions actions = new Actions(driver);

        LoginPage loginPage = new LoginPage(driver);

        loginPage.login("lvc","123456");

        Thread.sleep(5000);

        WebElement homeTool = driver.findElement(By.xpath("//div[@id='homeTool']"));
        actions.scrollToElement(homeTool).perform();

        WebElement filmPlayButton = driver.findElement(By.xpath("//div[@id='lichChieu']//button[contains(@class,'MuiFab-root')]"));
        actions.moveToElement(filmPlayButton).perform();

        WebElement buyTicket = driver.findElement(By.xpath("//a[@class=\"jss294\" and contains(.,'MUA VÉ')]"));
        buyTicket.click();

        Thread.sleep(2000);

        WebElement choseTime = driver.findElement(By.xpath("//a[contains(@href,'/purchase/')][1]"));
        choseTime.click();


        Thread.sleep(5000);
        WebElement moveSitting = driver.findElement(By.xpath("//span[contains(text(),'6')]"));
        actions.scrollToElement(moveSitting).perform();

        PurchasePage purchasePage = new PurchasePage(driver);
        purchasePage.bookingSlot("6");

        Thread.sleep(2000);
        WebElement agreeButton = driver.findElement(By.xpath("//button[text()='Đồng ý']"));
        agreeButton.click();

        ProfilePage profilePage = new ProfilePage(driver);
        profilePage.verifyBookingPrice("120000");
    }

}
