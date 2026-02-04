package pages.components;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class SimpleOutputComponent {
    public void checkOutput(String key, String value){
        $("#output").$("#"+key).shouldHave(text(value));
    }
}
