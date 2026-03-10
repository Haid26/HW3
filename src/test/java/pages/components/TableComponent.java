package pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TableComponent {

    private final static SelenideElement table = $(".table-responsive");

    public void checkResult(String key, String value) {
        if (!value.isEmpty())
            table.$(byText(key)).parent().shouldHave(text(value));
    }

    public void checkNoTable() {
        table.shouldNot().exists();
    }
}
