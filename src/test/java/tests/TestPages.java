package tests;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.params.provider.ValueSource;

import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class TestPages {

    String url = "https://www.jetbrains.com/";
    String headerText = "Essential tools for software developers and teams";
    String titleText = "Subscription Options and Pricing";
    SelenideElement header= $(".rs-text-1"),
            cartIcon = $("[data-test='site-header-cart-action']"),
            headerBuyPage = $(".jb-buy-page__header"),
            openSearch = $("button[aria-label='Open search']"),
            placeholderClick = $("input[placeholder='Ctrl+K for advanced search']"),
            quickSearchResult = $(".quick-search__results-query"),
            languagePicker = $("[data-test='language-picker']");
    ElementsCollection resultTitle = $$("[data-test='result-title']"),
            listItemContent = $$(".wt-list-item__content"),
            mainMenuResult = $$("[data-test='main-menu']");



    public TestPages openPage(){
        open(url);
        header.shouldHave(text(headerText))
                .shouldBe(visible);
        return this;
    }

    public TestPages redirectionStore(){
        Selenide.open(url);
        cartIcon.click();
        headerBuyPage.shouldHave(text(titleText))
                .shouldBe(visible);
        return this;
    }

    public TestPages openSearch(String testData){
        Selenide.open(url);
        openSearch.click();
        placeholderClick.setValue(testData);
        quickSearchResult.shouldHave(text(testData)).shouldBe(visible);
        return this;
    }

    public TestPages openSearchExtended(String testData, String expectedResult){
        Selenide.open(url);
        openSearch.click();
        placeholderClick.setValue(testData);
        resultTitle.find(text(expectedResult)).shouldBe(visible);
        return this;
    }

    public TestPages checkLanguageChange(EnumLang enumLang, String expectedResult){
        Selenide.open(url);
        languagePicker.click();
        listItemContent.find(text(enumLang.name())).click();
        mainMenuResult.filter(visible).shouldHave(texts(expectedResult));
        return this;
    }
}
