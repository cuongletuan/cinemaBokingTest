package scripts;

import drivers.DriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

import java.time.Duration;

public class baseTest {

    static WebDriver driver;

    static Logger logger = LogManager.getLogger("cinemaBookingTest");

    @BeforeMethod
    @Parameters({"browser"})
    public void setupTest(@Optional("chrome") String browser){

        logger.info("Setting up WebDriver");

        DriverFactory driverFactory = new DriverFactory();
        driverFactory.setDriver(browser);
        driver = driverFactory.getDriver();
        driver.get("https://demo1.cybersoft.edu.vn/");
    }

    public WebDriver getDriver() {
        return driver;
    }
}
