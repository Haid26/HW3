package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.Map;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.executeAsyncJavaScript;

public class TestBase {
    @BeforeAll
    static void beforeAll() {

        System.out.println(System.getProperty("browserVersion"));
        Configuration.pageLoadStrategy = "eager";
        Configuration.timeout = 5000;

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("selenoid:options", Map.<String, Object>of(
                "enableVNC", true,
                "enableVideo", true
        ));
        Configuration.browserCapabilities = capabilities;

        Configuration.browserSize = System.getProperty("browserSize");
        Configuration.baseUrl = System.getProperty("baseUrl");
        Configuration.browser = System.getProperty("browser", "chrome");
        //Configuration.browserVersion = System.getProperty("browserVersion");
        Configuration.headless = Boolean.parseBoolean(System.getProperty("headless"));
        Configuration.remote = System.getProperty("remote");


    }

    @BeforeEach
    void addAllureSelenideListener() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
    }

    @AfterEach
    void addAttachments() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();
        tearDown();
    }


    void tearDown() {
        closeWebDriver();
    }
}

