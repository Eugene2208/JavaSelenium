package base;

import PropertyHelper.PropertiesCache;
import org.openqa.selenium.Beta;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.MailStartPage;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;


public class Hw14 extends BaseTest {

    @Test
    public void validLog()  {
        MailStartPage mailStartPage =new MailStartPage(driver);
        mailStartPage.loggedIn(PropertiesCache.getInstance().getProperty("login"),PropertiesCache.getInstance().getProperty("password"));
        Assert.assertTrue(By.cssSelector("a[class='user']")!=null);
    }
    @Test
    public void sendMail() {
       validLog();
       driver.findElement(By.cssSelector(".site_sections li a[title='Почта']")).click();
        WebElement explicitWait = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".make_message > a")));
        driver.findElement(By.cssSelector(".make_message > a")).click();
        driver.findElement(By.id("to")).sendKeys(PropertiesCache.getInstance().getProperty("mail"));
        driver.findElement(By.id("text")).sendKeys("test");
        driver.findElement(By.name("subject")).sendKeys("test");
        driver.findElement(By.cssSelector(".clear > .bold")).click();
        driver.findElement(By.cssSelector(".new > a")).click();
        WebElement explicitWait2 = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".row:nth-child(20) .frm")));

        WebElement findSender = driver.findElement(By.cssSelector("#mesgList > form > div:nth-child(20) > a > span.frm")); //Получаем отправителя
        String Sender = findSender.getText(); //Получаем его текст
        Assert.assertTrue(Sender.contains("Евгений Мороз"));
        WebElement findSendText = driver.findElement(By.cssSelector("#mesgList > form > div:nth-child(20) > a > span.sbj > span")); //Получаем отправителя
        String SendText = findSendText.getText(); //Получаем его текст
    }
}
