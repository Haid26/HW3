package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import pages.components.SimpleOutputComponent;


import static com.codeborne.selenide.Selenide.*;
public class TextBoxPage {

    private final SelenideElement fullNameInput = $("#userName"),
            emailInput = $("#userEmail"),
            currentAddressInput = $("#currentAddress"),
            permanentAddressInput = $("#permanentAddress"),
            submitButton = $("#submit");

    private static SimpleOutputComponent simpleOutput = new SimpleOutputComponent();

    @Step("Open page with textboxes")
    public TextBoxPage openPage()
    {
        open("/text-box");
        return this;
    }

    @Step("Hide banners")
    public TextBoxPage hideBanners()
    {
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        return this;
    }

    @Step("Set full name as \"{value}\"")
    public TextBoxPage setFullName (String value){
        fullNameInput.setValue(value);
        return this;
    }

    @Step("Set email as \"{value}\"")
    public TextBoxPage setEmail (String value){
        emailInput.setValue(value);
        return this;
    }

    @Step("Set current address as \"{value}\"")
    public TextBoxPage setCurrentAddress (String value){
        currentAddressInput.setValue(value);
        return this;
    }

    @Step("Set permanent address as \"{value}\"")
    public TextBoxPage setPermanentAddress (String value){
        permanentAddressInput.setValue(value);
        return this;
    }

    @Step("Click submit")
    public TextBoxPage submitClick(){
        submitButton.click();
        return this;
    }

    @Step("Check that \"{key}\" = \"{value}\"")
    public TextBoxPage checkOutput(String key, String value){
        simpleOutput.checkOutput(key, value);
        return this;
    }

}
