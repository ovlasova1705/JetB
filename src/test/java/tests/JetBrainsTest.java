package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.List;
import java.util.stream.Stream;

import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;


public class JetBrainsTest extends TestBase {

    @DisplayName("1.Verify Website Can Be Opened")
    @Tag("remote1")
    @Test
    void firstTest() {
        testPages.openPage();
//        Selenide.open("https://www.jetbrains.com/");
//        $(".rs-text-1").shouldHave(text("Essential tools for software developers and teams"))
//                .shouldBe(visible);
    }

    @DisplayName("2.Verify Redirection to Store Page from Cart Icon Click")
    @Tag("remote1")
    @Test
    void secondTest() {
        testPages.redirectionStore();
//        Selenide.open("https://www.jetbrains.com/");
//        $("[data-test='site-header-cart-action']").click();
//        $(".jb-buy-page__header").shouldHave(text("Subscription Options and Pricing"))
//                .shouldBe(visible);
    }
}



