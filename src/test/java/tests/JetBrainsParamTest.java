package tests;

import com.codeborne.selenide.Selenide;
import io.qameta.allure.Description;
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


    @Tag("remote2")
    @ValueSource(strings = {"java", "kotlin"})
    @ParameterizedTest(name = "Showing results for {0}")
    @DisplayName("3.Verify Proper Functioning of Search - Short")
    void valueSourceCommon(String testData) {
        testPages.openSearch(testData);
    }

    @Tag("remote2")
    @CsvFileSource(resources = {"/testData/TestDataJet.csv"})
    @ParameterizedTest(name = "first result for {0} should contain {1}")
    @DisplayName("4.Verify Proper Functioning of Search -Extended")
    void csvFileSourceParametrizedTest(String testData, String expectedResult) {
        testPages.openSearchExtended(testData, expectedResult);
    }


    @Tag("remote2")
    @ParameterizedTest(name = "5.Verify Page Language Change - List of buttons (1) should show up for language {0} ")
    @MethodSource(value = "dataProvider")
    void siteShouldContainsAllOfGivenButtonsForGivenLanguage(EnumLang enumLang, String expectedResult) {
        testPages.checkLanguageChange(enumLang,expectedResult);
    }
}









