package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MailStartPage extends BasePage{
    public MailStartPage(WebDriver driver) {
        super(driver);
    }
    private WebElement log = driver.findElement(By.cssSelector("input[tabindex='1']"));
    private WebElement pas = driver.findElement(By.cssSelector("input[tabindex='2']"));
    public void loggedIn(String login,String password) {
        log.sendKeys(login);
        pas.sendKeys(password);
        driver.findElement(By.cssSelector("input[tabindex='5']")).click();
    }


}
