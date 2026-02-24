package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;

public class TestBase {
    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
        Configuration.timeout = 5000;
//        Configuration.remote = "https://user1:1234@selenoid.autotests.cloud/wd/hub";
//        Configuration.browser = "chrome";
//        Configuration.browserVersion = "128.0";
    }
}
