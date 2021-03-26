package tests.steps;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import tests.TestBase;

public class AnnotatedStepsTests extends TestBase {

    private final static String REPOSITORY = "elena-balakina/qa_guru_allure";
    private WebSteps step = new WebSteps();

    @Test
    @Owner("ebalakina")
    @Feature("Main menu")
    @Story("Menu Issue")
    @DisplayName("Annotated steps test. Check menu 'Issue' in repository")
    @Severity(SeverityLevel.BLOCKER)
    @Link(name = "BaseURL", url = "https://github.com")
    public void IssueTabTest() {
        step.openMainPage();
        step.searchForRepository(REPOSITORY);
        step.goToRepository(REPOSITORY);
        step.clickOnIssueTab();
        step.shouldSeeWelcomeText();
    }
}
