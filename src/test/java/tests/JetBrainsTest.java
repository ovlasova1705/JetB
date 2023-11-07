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


    @Tag("remote1")
    @Test
    @DisplayName("Verify Website Can Be Opened")
    void firstTest() {
        testPages.openPage();
    }


    @Tag("remote1")
    @Test
    @DisplayName("Verify Redirection to Store Page from Cart Icon Click")
    void secondTest() {
        testPages.redirectionStore();
    }
}



