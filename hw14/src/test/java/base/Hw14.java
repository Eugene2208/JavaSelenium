package base;

import org.openqa.selenium.Beta;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;


public class Hw14 extends BaseTest {
    List<String> files = Files.readAllLines(Paths.get(this.getClass().getClassLoader().getResource("LogDate.properties").toURI()));

    public Hw14() throws IOException, URISyntaxException {
    }

    @Test

    public void validLog() throws InterruptedException {

        driver.findElement(By.cssSelector("a[onclick='return i_showFloat(1);']")).click();
        driver.findElement(By.cssSelector("fieldset input[name='login']")).sendKeys(files.get(0));
        driver.findElement(By.cssSelector("fieldset input[name='pass']")).sendKeys(files.get(1));
        driver.findElement(By.cssSelector("input:nth-child(7)")).click();
        WebElement searchResult = driver.findElement(By.cssSelector(".right a[title='выйти']")); //Получаем результат поиска
        String resultText = searchResult.getText(); //Получаем его текст
        Assert.assertTrue(resultText.contains("Выход"));


    }

    @Test
    public void ivalidLog() {
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
    public void sendMail() throws InterruptedException {
        driver.findElement(By.linkText("Вход")).click();
        driver.findElement(By.cssSelector("fieldset input[name='login']")).sendKeys(files.get(0));
        driver.findElement(By.cssSelector("fieldset input[name='pass']")).sendKeys(files.get(1));
        driver.findElement(By.cssSelector("input:nth-child(7)")).click();
       driver.findElement(By.cssSelector(".site_sections li a[title='Почта']")).click();
        WebElement explicitWait = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".make_message > a")));
        driver.findElement(By.cssSelector(".make_message > a")).click();
        driver.findElement(By.id("to")).sendKeys("zhenyamoroz2208@i.ua");
        driver.findElement(By.id("text")).sendKeys("test11");
        driver.findElement(By.name("subject")).sendKeys("test11");
        driver.findElement(By.cssSelector(".clear > .bold")).click();
        driver.findElement(By.cssSelector(".new > a")).click();
        WebElement explicitWait2 = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".row:nth-child(20) .frm")));

        WebElement searchResult = driver.findElement(By.cssSelector(".row:nth-child(20) .frm")); //Получаем результат поиска
        String resultText = searchResult.getText(); //Получаем его текст
        System.out.println(resultText);
        //Assert.assertTrue(resultText.contains("Выход"));

    }

}
