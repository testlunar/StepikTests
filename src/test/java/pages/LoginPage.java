package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class LoginPage {
    private SelenideElement
            idLoginEmail = $("#id_login_email"),
            idLoginPassword = $("#id_login_password"),
            signButton = $(".sign-form__btn"),
            signMessages = $(".sign-form__messages");


    public LoginPage sendWrongEmailPassword() {
        idLoginEmail.sendKeys("bra@nail.ru");
        idLoginPassword.sendKeys("bra");
        signButton.click();
        signMessages.shouldHave(text("E-mail адрес и/или пароль не верны."));
        return this;
    }


}
