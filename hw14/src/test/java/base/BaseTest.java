package base;

import PropertyHelper.PropertiesCache;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class BaseTest {
    protected WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver(); //Открываем браузер
        driver.manage().window().maximize(); //Открываем окно браузера на весь экран
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.get(PropertiesCache.getInstance().getProperty("BaseURL")); //Переходим по URL
    }

    @AfterMethod
    public void tearDown() {
        driver.manage().deleteAllCookies();
        driver.close(); //Закрываем браузер
        driver.quit(); //Закрываем браузер
    }
}
