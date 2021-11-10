import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.*;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;
import static org.openqa.selenium.By.partialLinkText;

public class SelenideTest {

    @Owner("apodgornova")
    @Feature("Поиск")
    @Story("Поиск в Issues, чистый SelenideListener")
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("Github test with Allure labels, clean SelenideListener")
    @Link(name = "GitHub", url = "https://github.com")
    @Test
    void testGithubIssueSelenide() {

        /*
        Написать тест на проверку названия Issue в репозитории через Web-интерфейс.
        Этот тест представить в трех вариантах:
        1. Чистый Selenide (с Listener)
         */

        SelenideLogger.addListener("allure", new AllureSelenide());

        open("https://github.com");
        $(".header-search-input").setValue(TestData.REPOSITORY);
        $(".header-search-input").pressEnter();
        $(linkText(TestData.REPOSITORY)).click();
        $(partialLinkText("Issues")).click();
        $(withText(TestData.ISSUE_NUMBER)).shouldBe(visible);

    }
}
