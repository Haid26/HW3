package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import pages.components.CalendarComponent;
import pages.components.TableComponent;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class PracticeFormPage {

    private final SelenideElement firstNameInput = $("#firstName"),
                            lastNameInput =  $("#lastName"),
                            userEmailIput = $("#userEmail"),
                            userNumberInput = $("#userNumber"),
                            genderPicker = $("#genterWrapper"),
                            userAdressInput = $("#currentAddress"),
                            hobbiesPicker = $("#hobbiesWrapper"),
                            dateOfBirthCalendar = $("#dateOfBirthInput"),
                            stateInput = $("#state"),
                            cityInput = $("#city"),
                            uploadPicture = $("#uploadPicture"),
                            submitButton = $("#submit"),
                            subjectsInput = $("#subjectsInput");

    private CalendarComponent birthDate = new CalendarComponent();
    private TableComponent resultTable = new TableComponent();

    public PracticeFormPage hideBanners(){
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        return this;
    }

    @Step("Open Registration page")
    public PracticeFormPage openPage()
    {
        open("/automation-practice-form");
        return this;
    }

    @Step("Set first name as \"{value}\"")
    public PracticeFormPage setFirstName (String value){
        firstNameInput.setValue(value);
        return this;
    }

    @Step("Set last name as \"{value}\"")
    public PracticeFormPage setLastName (String value){
        lastNameInput.setValue(value);
        return this;
    }

    @Step("Set email as \"{value}\"")
    public PracticeFormPage setUserEmail (String value){
        userEmailIput.setValue(value);
        return this;
    }

    @Step("Set phone number as \"{value}\"")
    public PracticeFormPage setUserNumber (String value){
        userNumberInput.setValue(value);
        return this;
    }

    @Step("Set user address as \"{value}\"")
    public PracticeFormPage setUserAdress (String value){
       userAdressInput.setValue(value);
        return this;
    }

    @Step("Set gender \"{value}\"")
    public PracticeFormPage setGender (String value){
        genderPicker.$(byText(value)).click();
        return this;
    }

    @Step("Set hobbie as \"{value}\"")
    public PracticeFormPage setHobbie (String value){
        if (value != "")
            hobbiesPicker.$(byText(value)).click();
        return this;
    }

    @Step("Upload picture \"{value}\"")
    public PracticeFormPage uploadPicture (String fileUrl){
        uploadPicture.uploadFromClasspath(fileUrl);
        return this;
    }

    @Step("Set state as \"{value}\"")
    public PracticeFormPage setState (String value){
        stateInput.click();
        stateInput.$(byText(value)).click();
        return this;
    }

    @Step("Set city as \"{value}\"")
    public PracticeFormPage setCity (String value){
        cityInput.click();
        cityInput.$(byText(value)).click();
        return this;
    }

    @Step("Set subject as \"{value}\"")
    public PracticeFormPage setSubject (String value){
        if (value != "") {
            subjectsInput.setValue(value).pressEnter();
        }
        return this;
    }

    @Step("Set birth date as \"{day} {month} {year}\"")
    public PracticeFormPage setDateOfBirth(String day, String month, String year)
    {
        dateOfBirthCalendar.click();
        birthDate.setDate(day,month,year);

        return this;
    }

    @Step("click submit")
    public PracticeFormPage submitClick()
    {
        submitButton.click();
        return this;
    }

    @Step("Check that \"{key}\" = \"{value}\"")
    public PracticeFormPage checkResult(String key, String value)
    {
        resultTable.checkResult(key,value);
        return this;
    }

    @Step("Check that there is no table")
    public PracticeFormPage checkNoTable()
    {
        resultTable.checkNoTable();
        return this;
    }
}
