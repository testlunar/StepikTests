package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.LoginPage;
import pages.MainPage;
import pages.SearchResultPage;

import static io.qameta.allure.Allure.step;

public class StepikTests extends TestBase{
    MainPage mainPage = new MainPage();
    SearchResultPage searchResultPage = new SearchResultPage();
    LoginPage loginPage = new LoginPage();

    String existingCourse = "Английский";
    String nonExistingCourse = "Телевизор";
    String freeCertificateCourse = "Java";
    String author = "Artyom Burylov Stanislav Deviatykh";
    int numberSize = 20;


    @Test
    @Tag("Positive")
    @DisplayName("Поиск товара по названию и проверка соответствия названия результату поиска")
    void searchItemTests() {

        step("Поиск курса по названию", () -> {
            mainPage.openPage();
            mainPage.searchItem(existingCourse);
        });

        step("Проверка релевантности первого результата поиска", () -> {
            searchResultPage.checkFirstResultTitleExist(existingCourse);
        });
        }

    @Test
    @Tag("Negative")
    @DisplayName("Поиск товара по нерелевантному названию курса и проверка,что курс не найден")
    void searchItemNegativeTest() {

        step("Поиск курса по названию", () -> {
            mainPage.openPage();
            mainPage.searchItem(nonExistingCourse);
        });

        step("Проверка релевантности первого результата поиска", () -> {
            searchResultPage.checkFirstResultTitleNotExist(nonExistingCourse);
        });
    }

    @Test
    @Tag("Positive")
    @DisplayName("Проверка,что количество найденных статей на странице равно 20")
    void checkSearchResultItemsNumberTest() {

        step("Поиск курса по названию", () -> {
            mainPage.openPage();
            mainPage.searchItem(existingCourse);
        });

        step("Проверка,что количество отображенных статей на странице равно " + numberSize, () -> {
            searchResultPage.checkResultsNumber(existingCourse, numberSize);
        });
    }

    @Test
    @Tag("Positive")
    @DisplayName("Проверка точного совпадения автора бесплатного курса с сертификатом после поиска")
    void searchCourseWithSertificateAndFreeTest() {

        step("Поиск бесплатного курса с сертификатом по слову ", () -> {
            mainPage.openPage();
            mainPage.searcCourseFreeAndWithCertificate(freeCertificateCourse);
        });

        step("Проверка,что фамилия первой статьи совпадает с  " + author, () -> {
            searchResultPage.checkAuthorNameFirstArticle(freeCertificateCourse, author);
        });
    }

    @Test
    @Tag("Negative")
    @DisplayName("Проверка ошибки при неверном логине или пароле")
    void checkLoginNegative() {

        step("Открытие формы логина", () -> {
            mainPage.openPage();
            mainPage.clickLogin();
        });

        step("Проверка ошибки при неверном логине или пароле", () -> {
            loginPage.sendWrongEmailPassword();
        });
    }
}


