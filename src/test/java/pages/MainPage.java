package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.type;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;

public class MainPage {

    private SelenideElement
            searcHeaderInput = $("[aria-label = Search]"),
            searchInput = $(".search-form__input"),
            sertificateCheckBox = $(By.xpath("//span[.='С сертификатами']")),
            forFreeCheckBox = $(By.xpath("//span[.='Бесплатные']")),
            searchButton = $(By.cssSelector(".search-form__submit")),
            auth_login = $(By.cssSelector(".navbar__auth_login"));

    public MainPage openPage() {
        open("/catalog");
        searcHeaderInput.shouldHave(type("search"));
        return this;
    }

    public MainPage searchItem(String value) {
        searcHeaderInput.sendKeys(value);
        searcHeaderInput.pressEnter();
        return this;
    }

    public MainPage searcCourseFreeAndWithCertificate(String value) {
        searchInput.sendKeys(value);
        sertificateCheckBox.click();
        forFreeCheckBox.click();
        searchButton.click();
        return this;
    }

    public MainPage clickLogin() {
        auth_login.click();
        return this;
    }
}
