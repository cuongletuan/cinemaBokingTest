package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.sql.Driver;

public class ProfilePage {

    WebDriver driver;

    public ProfilePage(WebDriver driver){
        this.driver = driver;
    }
    public void verifyBookingPrice(String price) {
        WebElement clickAvatar = driver.findElement(By.xpath("//a[@href='/account']"));
        clickAvatar.click();

        String lastPurchasedPrice = driver.findElement(By.xpath("(//h3[contains(text(), 'Giá vé:')])[last()]")).getText();
        if(lastPurchasedPrice.equals(price+" VND")) {
            System.out.println("PASSED!!!");
        } else {
            System.out.println("FAILED!!!");
        }
    }
    public void verifyBookingPriceAndName(String price, String FilmName) {
        WebElement clickAvatar = driver.findElement(By.xpath("//a[@href='/account']"));
        clickAvatar.click();

        String lastPurchasedPrice = driver.findElement(By.xpath("(//h3[contains(text(), 'Giá vé:')])[last()]")).getText();
        String lastPurchasedFilmName = driver.findElement(By.xpath("(//h1[contains(text(), 'Tên phim:')])[last()]")).getText();
        if(lastPurchasedPrice.equals(price+" VND") && lastPurchasedFilmName.equals(FilmName)) {
            System.out.println("PASSED!!!");
        } else {
            System.out.println("FAILED!!!");
        }
    }
}
