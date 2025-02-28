package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Arrays;

public class PurchasePage {
    WebDriver driver;

    public PurchasePage(WebDriver driver){
        this.driver = driver;
    }

    public void bookingSlot(String number) {
        //Chọn ghế
        WebElement selectChair = driver.findElement(By.xpath("//span[contains(text(), '"+number+"')]"));
        selectChair.click();

        //Chọn Đặt vé:
        WebElement bookSelectedChairTicket = driver.findElement(By.xpath("//span[contains(text(), 'ĐẶT VÉ')]"));
        bookSelectedChairTicket.click();
    }

    public void bookingManySlot(String [] number){
        for (int i=0; i< number.length; i++){
            WebElement selectChair = driver.findElement(By.xpath("//span[contains(text(), '"+ number[i] +"')]"));
            selectChair.click();
        }
        WebElement bookSelectedChairTicket = driver.findElement(By.xpath("//span[contains(text(), 'ĐẶT VÉ')]"));
        bookSelectedChairTicket.click();
    }
}
