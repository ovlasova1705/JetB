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



    @ValueSource(strings = {"java", "kotlin"})
    @Tag("remote2")
    @ParameterizedTest
    @DisplayName("3.Verify Proper Functioning of Search - Short")
    void valueSourceCommon(String testData) {
        testPages.openSearch(testData);
    }

    @CsvFileSource(resources = {"/testData/TestDataJet.csv"})
    @Tag("remote2")
    @ParameterizedTest
    @DisplayName("4.Verify Proper Functioning of Search -Extended")
    void csvFileSourceParametrizedTest(String testData, String expectedResult) {
        testPages.openSearchExtended(testData, expectedResult);
    }


    @Tag("remote2")
    @ParameterizedTest
    @DisplayName("5.Verify Page Language Change")
    @MethodSource(value = "dataProvider")
    void siteShouldContainsAllOfGivenButtonsForGivenLanguage(EnumLang enumLang, String expectedResult) {
        testPages.checkLanguageChange(enumLang,expectedResult);
    }
}









