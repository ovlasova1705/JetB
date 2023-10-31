package tests;

import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.stream.Stream;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;


public class JetBrainsParamTest extends TestBase {


    @DisplayName("3.Verify Proper Functioning of Search - Short")
    @ValueSource(strings = {"java", "kotlin"})
    @Tag("remote2")
    @ParameterizedTest(name = "Showing results for {0}")
    void valueSourceCommon(String testData) {
        testPages.openSearch(testData);
//        Selenide.open("https://www.jetbrains.com/");
//        $("button[aria-label='Open search']").click();
//        $("input[placeholder='Ctrl+K for advanced search']").setValue(testData);
//        $(".quick-search__results-query").shouldHave(text(testData)).shouldBe(visible);
    }

    @Disabled
    @CsvSource(value = {
            "java, IntelliJ IDEA – the Leading Java and Kotlin IDE",
            "kotlin, IntelliJ IDEA – the Leading Java and Kotlin IDE",
    })
    @ParameterizedTest(name = "first result for {0} should contain {1}")
    void csvSourceParamTest(String testData, String expectedResult) {
        Selenide.open("https://www.jetbrains.com/");
        $("button[aria-label='Open search']").click();
        $("input[placeholder='Ctrl+K for advanced search']").setValue(testData);
        $$("[data-test='result-title']").find(text(expectedResult)).shouldBe(visible);

    }

    @DisplayName("4.Verify Proper Functioning of Search -Extended")
    @CsvFileSource(resources = {"/testData/TestDataJet.csv"})
    @Tag("remote2")
    @ParameterizedTest(name = "first result for {0} should contain {1}")
    void csvFileSourceParametrizedTest(String testData, String expectedResult) {
        testPages.openSearchExtended(testData, expectedResult);
//        Selenide.open("https://www.jetbrains.com/");
//        $("button[aria-label='Open search']").click();
//        $("input[placeholder='Ctrl+K for advanced search']").setValue(testData);
//        $$("[data-test='result-title']").find(text(expectedResult)).shouldBe(visible);
    }


    @DisplayName("5.Verify Page Language Change")
    @Tag("remote2")
    @ParameterizedTest(name = "List of buttons (1) should show up for language {0} ")
    @MethodSource(value = "dataProvider")
    void siteShouldContainsAllOfGivenButtonsForGivenLanguage(EnumLang enumLang, String expectedResult) {
        testPages.checkLanguageChange(enumLang,expectedResult);
//        Selenide.open("https://www.jetbrains.com/");
//        $("[data-test='language-picker']").click();
//        $$(".wt-list-item__content").find(text(enumLang.name())).click();
//        $$("[data-test='main-menu']").filter(visible).shouldHave(texts(expectedResult));
    }
}









