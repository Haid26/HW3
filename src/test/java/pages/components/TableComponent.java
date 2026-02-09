package pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class TableComponent {

    private final static SelenideElement table = $(".table-responsive");

    public void checkResult (String key, String value) {

        table.$(byText(key)).parent().shouldHave(text(value));
    }

    public void checkNoTable(){

        table.shouldNot().exists();
    }
}
