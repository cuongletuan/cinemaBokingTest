package scripts;

import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.ProfilePage;
import pages.PurchasePage;

public class cinemaBookingFromSearchBar extends baseTest{

    @Test
    public void verifyBookingFromSearchBar(){

        driver.findElement(By.xpath("//a[@href='/sign-in']")).click();

        LoginPage loginPage = new LoginPage(driver);

        loginPage.inputUser("lvc");
        loginPage.inputPassword("123456");
        loginPage.loginButton();

        HomePage homePage = new HomePage(driver);
        homePage.selectSlotTab();

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
