package pages.components;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class TableComponent {

    public void checkResult (String key, String value)
    {
        $(".table-responsive").$(byText(key)).parent().shouldHave(text(value));
    }
}
