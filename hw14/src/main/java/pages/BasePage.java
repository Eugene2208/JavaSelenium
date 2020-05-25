package pages;

import static com.codeborne.selenide.WebDriverRunner.url;


public abstract class BasePage {

    public String getPageUrl() {
        return url();
    }
}