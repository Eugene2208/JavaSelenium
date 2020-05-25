package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class MailStartPage extends BasePage {
    private SelenideElement log = $("input[tabindex='1']");
    private SelenideElement pas = $("input[tabindex='2']");

    public void loggedIn(String login, String password) {
        log.sendKeys(login);
        pas.sendKeys(password);
        $("input[tabindex='5']").click();
    }

    public void sendMail(String to, String subject, String text) {
        $(".site_sections li a[title='Почта']");
        $(".make_message > a").click();
        $(By.id("to")).sendKeys(to);
        $(By.name("subject")).sendKeys(subject);
        $(By.id("text")).sendKeys(text);
        $("body > div.body_container > div.Body > div.Cols_80_20.message_container > div.Left > p:nth-child(1) > input.bold").click();
    }
}