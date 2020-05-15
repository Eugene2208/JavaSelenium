import org.openqa.selenium.Beta;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.awt.*;

public class Hw14 {
    private WebDriver driver;
    public static final String LOG = "zhenyamoroz2208";
    public static final String PAS = "0000adab";

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver(); //Открываем браузер
        driver.manage().window().maximize(); //Открываем окно браузера на весь экран
        driver.get("https://www.i.ua/"); //Переходим по URL
    }
     @AfterMethod
       public void tearDown() {

         driver.close(); //Закрываем браузер
          driver.quit(); //Закрываем браузер
     }
    @Test
    public void validLog()  {
        driver.findElement(By.linkText("Вход")).click();
        driver.findElement(By.cssSelector("fieldset input[name='login']")).sendKeys(LOG);
        driver.findElement(By.cssSelector("fieldset input[name='pass']")).sendKeys(PAS);
        driver.findElement(By.cssSelector("input:nth-child(7)")).click();


    }
    @Test
    public void ivalidLog()  {
        driver.findElement(By.linkText("Вход")).click();
        driver.findElement(By.cssSelector("fieldset input[name='login']")).sendKeys("");
        driver.findElement(By.cssSelector("fieldset input[name='pass']")).sendKeys("");
        driver.findElement(By.cssSelector("input:nth-child(7)")).click();
        WebElement searchResult = driver.findElement(By.cssSelector(".right a[title='выйти']")); //Получаем результат поиска
        String resultText = searchResult.getText(); //Получаем его текст
        Assert.assertTrue(resultText.contains("Выход")); //Проверка: Результат поиска содержит условие поиска

    }
    @Beta
    @Test
    public void sendMail() throws InterruptedException{
        driver.findElement(By.linkText("Вход")).click();
        driver.findElement(By.cssSelector("fieldset input[name='login']")).sendKeys(LOG);
        driver.findElement(By.cssSelector("fieldset input[name='pass']")).sendKeys(PAS);
        driver.findElement(By.cssSelector("input:nth-child(7)")).click();
        Thread.sleep(1000);
        driver.findElement(By.cssSelector(".site_sections li a[title='Почта']")).click();
        Thread.sleep(1000);
        driver.findElement(By.cssSelector(".make_message > a")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("to")).sendKeys("zhenyamoroz2208@i.ua");
        driver.findElement(By.id("text")).sendKeys("test11");
        driver.findElement(By.name("subject")).sendKeys("test11");
        Thread.sleep(1000);
        driver.findElement(By.cssSelector(".clear > .bold")).click();
        Thread.sleep(1000);
        driver.findElement(By.cssSelector(".new > a")).click();
        Thread.sleep(6000);
        WebElement searchResult = driver.findElement(By.cssSelector(".row:nth-child(20) .frm")); //Получаем результат поиска
        String resultText = searchResult.getText(); //Получаем его текст
        System.out.println(resultText);
        //Assert.assertTrue(resultText.contains("Выход")); //Проверка: Результат поиска содержит условие поиска

    }

}
