import org.junit.jupiter.api.Test;
import steps.WebSteps;

public class StepAnnotatedTest {

    private final WebSteps steps = new WebSteps();

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

    }

}
