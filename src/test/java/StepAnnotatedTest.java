import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import steps.WebSteps;

public class StepAnnotatedTest {

    private final WebSteps steps = new WebSteps();

    @Owner("apodgornova")
    @Feature("Поиск")
    @Story("Поиск в Issues, annotated steps")
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("Github test with Allure labels with steps annotated")
    @Link(name = "GitHub", url = "https://github.com")
    @Test()
    void testGithubIssueAnnotatedSteps() {

        /*
        Написать тест на проверку названия Issue в репозитории через Web-интерфейс.
        Этот тест представить в трех вариантах:
        3. Шаги с аннотацией @Step
         */

        steps.openMainPage();
        steps.searchForRepository(TestData.REPOSITORY);
        steps.goToRepository(TestData.REPOSITORY);
        steps.openIssueTab();
        steps.shouldSeeIssueWithNumber(TestData.ISSUE_NUMBER);
        steps.takeScreenshot();

    }

}
