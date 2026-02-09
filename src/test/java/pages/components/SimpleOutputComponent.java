package pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class SimpleOutputComponent {
    private final SelenideElement output = $("#output");

    public void checkOutput(String key, String value){
        output.$("#"+key).shouldHave(text(value));
    }
}
