package pages;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class SearchResultPage {
    private SelenideElement
            searchInput = $(".search-form__input");


    private ElementsCollection seatchResultsList = $$("[data-list-type=search-results] ul li");


    public SearchResultPage checkFirstResultTitleExist(String value) {
        seatchResultsList.first().shouldHave(Condition.text(value));
        return this;
    }

    public SearchResultPage checkFirstResultTitleNotExist(String value) {
        seatchResultsList.first().shouldNotHave(Condition.text(value));
        return this;
    }

    public SearchResultPage checkResultsNumber(String value, int number) {
        seatchResultsList.shouldHave(CollectionCondition.size(number));
        return this;
    }

    public SearchResultPage checkAuthorNameFirstArticle(String value,String author) {
        seatchResultsList.first().shouldHave(Condition.text(author));
        return this;
    }
}
