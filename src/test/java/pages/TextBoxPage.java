package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.SimpleOutputComponent;


import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;
public class TextBoxPage {

    private final SelenideElement fullNameInput = $("#userName"),
            emailInput = $("#userEmail"),
            currentAddressInput = $("#currentAddress"),
            permanentAddressInput = $("#permanentAddress"),
            submitButton = $("#submit");

    private static SimpleOutputComponent simpleOutput = new SimpleOutputComponent();
    public TextBoxPage openPage()
    {
        open("/text-box");
        return this;
    }

    public TextBoxPage hideBanners()
    {
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        return this;
    }

    public TextBoxPage setFullName (String value){
        fullNameInput.setValue(value);
        return this;
    }

    public TextBoxPage setEmail (String value){
        emailInput.setValue(value);
        return this;
    }

    public TextBoxPage setCurrentAddress (String value){
        currentAddressInput.setValue(value);
        return this;
    }

    public TextBoxPage setPermanentAddress (String value){
        permanentAddressInput.setValue(value);
        return this;
    }

    public TextBoxPage submitClick(){
        submitButton.click();
        return this;
    }

    public TextBoxPage checkOutput(String key, String value){
        simpleOutput.checkOutput(key, value);
        return this;
    }

}
