package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class HomePage {
    WebDriver driver;

    public HomePage(WebDriver driver){
        this.driver = driver;
    }

    public void selectSlotFromPanel(String filmName, String date){
        // Chọn Thời gian
        WebElement bookTime = driver.findElement(By.xpath("//h2[contains(text(),'"+filmName+"')]/following-sibling::div//p[text()='"+date+"']"));
        bookTime.click();
    }

    public void selectSlotTab(){
        driver.findElement(By.xpath("//select//option[contains(text(),'Phim')]/following-sibling::option")).click();
        driver.findElement(By.xpath("//select//option[contains(text(),'Rạp')]/following-sibling::option")).click();
        driver.findElement(By.xpath("//select//option[contains(text(),'Ngày giờ chiếu')]/following-sibling::option")).click();
        driver.findElement(By.xpath("//span[text()='MUA VÉ NGAY']")).click();
    }

    public void selectSlotVerticalTab(String cinema,String location, String filmName, String date){
        Actions actions = new Actions(driver);

        WebElement scrollCinema = driver.findElement(By.xpath("//img[@alt='"+cinema+"']"));
        actions.scrollToElement(scrollCinema).perform();
        driver.findElement(By.xpath("//img[@alt='"+cinema+"']")).click();

        WebElement scrollLocation = driver.findElement(By.xpath("//h4[text()='"+location+"']"));
        actions.scrollToElement(scrollLocation).perform();
        driver.findElement((By.xpath("//h4[text()='"+location+"']"))).click();

        WebElement scrollFilmName = driver.findElement(By.xpath("//h2[contains(text(),'"+filmName+"')]"));
        actions.scrollToElement(scrollFilmName).perform();
        driver.findElement(By.xpath("//h2[contains(text(),'"+filmName+"')]/following-sibling::div//p[contains(text(),'"+date+"')]")).click();
    }
}
