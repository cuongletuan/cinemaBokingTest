package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(5));
        driver.manage().window().maximize();

        driver.get("https://demo1.cybersoft.edu.vn/");
        Thread.sleep(3000);

        /* actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.id("homeTool"))).perform();
        String tuaPhim = driver.findElement(By.xpath("//div[@class='jss200']")).getText();
        System.out.println(tuaPhim);*/


        /*driver.findElement(By.xpath("//a[@href='/sign-in']")).click();

        WebElement username = driver.findElement(By.name("taiKhoan"));
        username.sendKeys("huydao226");

        WebElement password = driver.findElement(By.name("matKhau"));
        password.sendKeys("asdEDZ12#");

        driver.findElement(By.xpath("//button[@type='submit']")).click();*/

        driver.findElement(By.xpath("//a[@href='/sign-in']")).click();
        WebElement checked = driver.findElement(By.xpath("//input[@type='checkbox']"));
        boolean isChecked = checked.isDisplayed();
        if(!isChecked){
            checked.click();
        }
    }
}