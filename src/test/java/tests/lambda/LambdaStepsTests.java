package tests.lambda;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import tests.TestBase;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class LambdaStepsTests extends TestBase {
    private final String BASE_URL = "https://github.com";
    private final static String REPOSITORY = "elena-balakina/qa_guru_allure";

    @Test
    @Owner("ebalakina")
    @Feature("Main menu")
    @Story("Menu Issue")
    @DisplayName("Lambda steps test. Check menu 'Issue' in repository")
    @Severity(SeverityLevel.BLOCKER)
    @Link(name = "BaseURL", url = "https://github.com")
    public void IssueTabTest() {
        step("Open main page", (step) -> {
            step.parameter("url", BASE_URL);
            open(BASE_URL);
        });

        step("Search for repository", (step) -> {
            step.parameter("repository", REPOSITORY);

            $(".header-search-input").click();
            $(".header-search-input").sendKeys(REPOSITORY);
            $(".header-search-input").submit();
        });

        step("Go to repository", () -> {
            $(By.linkText(REPOSITORY)).click();
        });

        step("Go to Issues", () -> {
            $(withText("Issues")).click();
        });

        step("Check welcome text", (step) -> {
            step.parameter("Expected result", "Welcome to issues!");

            $(".blankslate h3").shouldHave(text("Welcome to issues!"));
        });
    }
}

