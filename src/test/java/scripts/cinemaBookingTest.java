package scripts;

import listeners.SimpleListener;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ProfilePage;
import pages.PurchasePage;

@Listeners(SimpleListener.class)
public class cinemaBookingTest extends baseTest {

    @Test
    public void verifyBookingByHomeTool() throws InterruptedException {
        Actions actions = new Actions(driver);

        driver.findElement(By.xpath("//a[@href='/sign-in']")).click();

        LoginPage loginPage = new LoginPage(driver);
        logger.info("Input logging");
        loginPage.inputUser("lvc");
        loginPage.inputPassword("123456");
        loginPage.loginButton();
        logger.info("End Login account");
        //Thread.sleep(5000);

        logger.info("Scroll Home Tool div");
        WebElement homeTool = driver.findElement(By.xpath("//div[@id='homeTool']"));
        actions.scrollToElement(homeTool).perform();

        WebElement filmPlayButton = driver.findElement(By.xpath("//div[@id='lichChieu']//button[contains(@class,'MuiFab-root')]"));
        actions.moveToElement(filmPlayButton).perform();

        WebElement buyTicket = driver.findElement(By.xpath("//a[@class=\"jss294\" and contains(.,'MUA VÉ')]"));
        buyTicket.click();

        WebElement choseTime = driver.findElement(By.xpath("//a[contains(@href,'/purchase/')][1]"));
        choseTime.click();


        Thread.sleep(5000);
        WebElement moveSitting = driver.findElement(By.xpath("//span[contains(text(),'29')]"));
        actions.scrollToElement(moveSitting).perform();

        PurchasePage purchasePage = new PurchasePage(driver);
        purchasePage.bookingSlot("35");
        WebElement agreeButton = driver.findElement(By.xpath("//button[text()='Đồng ý']"));
        agreeButton.click();

        ProfilePage profilePage = new ProfilePage(driver);
        profilePage.verifyBookingPrice("120000");
    }
    @AfterMethod
    public void quit(){
        driver.quit();
    }
}
