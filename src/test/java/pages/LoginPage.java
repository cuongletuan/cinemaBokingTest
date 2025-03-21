package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class LoginPage {
    WebDriver driver;

    public LoginPage(WebDriver driver){
        this.driver = driver;
    }

    public void inputUser (String userName) {
        driver.findElement(By.xpath("//input[@id=\"taiKhoan\"]")).sendKeys(userName);
    }
    public void inputPassword(String pwd){
        driver.findElement(By.xpath("//input[@id=\"matKhau\"]")).sendKeys(pwd);
    }

    public void loginButton(){
        WebElement remember = driver.findElement(By.name("remember"));
        boolean isRemember = remember.isSelected();
        if (!isRemember){
            remember.click();
        }
        driver.findElement(By.xpath("//span[text()='Đăng nhập']")).click();
    }
//    public void verifyInputData(){
//
//        WebElement checkUserInput = driver.findElement(By.xpath("//p[@id='taiKhoan-helper-text']"));
//        Assert.assertTrue(checkUserInput.isDisplayed());
//
//        String checkInputPwd = driver.findElement(By.xpath("//p[@id='matKhau-helper-text']")).getText();
//        Assert.assertTrue(checkInputPwd.contains("Đây là trường bắt buộc !"));
//    }
}
