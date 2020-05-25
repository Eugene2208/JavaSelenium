package base;

import PropertyHelper.PropertiesCache;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.MailStartPage;
import static com.codeborne.selenide.Selenide.$;


public class Hw14 extends BaseTest {

    @Test
    public void validLog() {
        MailStartPage mailStartPage = new MailStartPage();
        mailStartPage.loggedIn(PropertiesCache.getInstance().getProperty("login"), PropertiesCache.getInstance().getProperty("password"));
        Assert.assertTrue($(".sn_menu_title").getText().contains(PropertiesCache.getInstance().getProperty("mail")));
    }

    @Test
    public void sendMail() {
        validLog();
        MailStartPage mailStartPage = new MailStartPage();
        mailStartPage.sendMail(PropertiesCache.getInstance().getProperty("mail"), "test", "test");
        $("body > div.body_container > div.section_nav > ul > li:nth-child(2) > a").click();
        Assert.assertTrue($("#mesgList > form > div > a > span.frm").getText().contains("Евгений Мороз"));
    }
}