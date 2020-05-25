package base;

import PropertyHelper.PropertiesCache;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;

import static com.codeborne.selenide.Selenide.open;

import java.util.concurrent.TimeUnit;

public class BaseTest {
    protected WebDriver driver;

    @BeforeMethod
    public void setUp() {
        open(PropertiesCache.getInstance().getProperty("url")); //Переходим по URL
    }
}