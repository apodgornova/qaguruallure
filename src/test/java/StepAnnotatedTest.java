import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;
import steps.WebSteps;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;
import static org.openqa.selenium.By.partialLinkText;

public class StepAnnotatedTest {

    private WebSteps steps = new WebSteps();

    @Test()
    void testGithubIssueAnnotatedSteps() {

        /*
        Написать тест на проверку названия Issue в репозитории через Web-интерфейс.
        Этот тест представить в трех вариантах:
        3. Шаги с аннотацией @Step
         */

        SelenideLogger.addListener("allure", new AllureSelenide());

        open("https://github.com");
        $(".header-search-input").setValue("eroshenkoam/allure-example");
        $(".header-search-input").pressEnter();

        $(linkText("eroshenkoam/allure-example")).click();
        $(partialLinkText("Issues")).click();
        $(withText("#68")).shouldBe(visible);

    }
}
