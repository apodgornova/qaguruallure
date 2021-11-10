import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.linkText;
import static org.openqa.selenium.By.partialLinkText;

public class LamdaTest {

    private static final String REPOSITORY = "eroshenkoam/allure-example";
    private static final Integer ISSUE_NUMBER = 68;

    @Test()
    void testGithubIssueLamda() {

        /*
        Написать тест на проверку названия Issue в репозитории через Web-интерфейс.
        Этот тест представить в трех вариантах:
        2. Лямбда шаги через step (name, () -> {})
         */

        SelenideLogger.addListener("allure", new AllureSelenide());

        step("Открываем главную страницу Github", () -> {
            open("https://github.com");
        });

        step("Ищем в поле поиска eroshenkoam/allure-example и запускаем поиск", () -> {
            $(".header-search-input").setValue(TestData.REPOSITORY);
            $(".header-search-input").pressEnter();
        });

        step("Переходим по первой найденной ссылке с текстом eroshenkoam/allure-example", () -> {
            $(linkText(TestData.REPOSITORY)).click();
        });

        step("Переходим на вкладку Issues", () -> {
            $(partialLinkText("Issues")).click();
        });

        step("Проверяем что на вкладке Issues есть issue c номером 68", () -> {
            $(withText(TestData.ISSUE_NUMBER)).shouldBe(visible);
        });

    }
}
