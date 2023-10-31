package tests;

import Helpers.Attach;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.provider.Arguments;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.util.stream.Stream;
import java.util.Map;
import static com.codeborne.selenide.CollectionCondition.texts;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class TestBase {

    TestPages testPages = new TestPages();

    @BeforeAll
    static void beforeAll() {
        Configuration.browser = System.getProperty("browser", "chrome");
        Configuration.browserVersion = System.getProperty("browserVersion", "100");
        Configuration.browserSize = System.getProperty("browserSize", "1920x1080");
        Configuration.remote = "https://user1:1234@selenoid.autotests.cloud/wd/hub";

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("selenoid:options", Map.<String, Object>of(
                "enableVNC", true,
                "enableVideo", true
        ));

        Configuration.browserCapabilities = capabilities;
    }

    @BeforeEach
    void addListener() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
    }

    @AfterEach
    void addAttachments() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();
    }



    static Stream<Arguments> dataProvider() {
        return Stream.of(
                Arguments.of(
                        EnumLang.English,
                        "Developer Tools Team Tools Education Solutions Support Store"
                ),
                Arguments.of(
                        EnumLang.Deutsch,
                        "Entwicklungstools Team-Tools Bildung Lösungen Support Store"
                ),
                Arguments.of(
                        EnumLang.Español,
                        "Para desarrolladores Para equipos Educación Soluciones Asistencia Tienda"
                )
        );
    }


}
