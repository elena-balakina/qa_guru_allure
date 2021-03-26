package tests.selenide;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.*;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import tests.TestBase;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class SelenideTests extends TestBase {
    private final String BASE_URL = "https://github.com";
    private final static String REPOSITORY = "elena-balakina/qa_guru_allure";

    @Test
    @Owner("ebalakina")
    @Feature("Main menu")
    @Story("Menu Issue")
    @DisplayName("Selenide test. Check menu 'Issue' in repository")
    @Severity(SeverityLevel.BLOCKER)
    @Link(name = "BaseURL", url = "https://github.com")
    public void IssueTabTest() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        open(BASE_URL);
        $(".header-search-input").click();
        $(".header-search-input").sendKeys(REPOSITORY);
        $(".header-search-input").submit();
        $(By.linkText(REPOSITORY)).click();
        $(withText("Issues")).click();
        $(".blankslate h3").shouldHave(text("Welcome to issues!"));
    }
}