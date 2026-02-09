package pages;

import com.codeborne.selenide.SelenideElement;
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

    public PracticeFormPage openPage()
    {
        open("/automation-practice-form");
        return this;
    }

    public PracticeFormPage hideBanners()
    {
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        return this;
    }

    public PracticeFormPage setFirstName (String value){
        firstNameInput.setValue(value);
        return this;
    }

    public PracticeFormPage setLastName (String value){
        lastNameInput.setValue(value);
        return this;
    }

    public PracticeFormPage setUserEmail (String value){
        userEmailIput.setValue(value);
        return this;
    }

    public PracticeFormPage setUserNumber (String value){
        userNumberInput.setValue(value);
        return this;
    }

    public PracticeFormPage setUserAdress (String value){
       userAdressInput.setValue(value);
        return this;
    }

    public PracticeFormPage setGender (String value){
        genderPicker.$(byText(value)).click();
        return this;
    }

    public PracticeFormPage setHobbie (String value){
        hobbiesPicker.$(byText(value)).click();
        return this;
    }

    public PracticeFormPage uploadPicture (String fileUrl){
        uploadPicture.uploadFromClasspath(fileUrl);
        return this;
    }

    public PracticeFormPage setState (String value){
        stateInput.click();
        stateInput.$(byText(value)).click();
        return this;
    }

    public PracticeFormPage setCity (String value){
        cityInput.click();
        cityInput.$(byText(value)).click();
        return this;
    }

    public PracticeFormPage setSubject (String value){
        subjectsInput.setValue(value).pressEnter();
        return this;
    }

    public PracticeFormPage setDateOfBirth(String day, String month, String year) {
        dateOfBirthCalendar.click();
        birthDate.setDate(day,month,year);

        return this;
    }

    public PracticeFormPage submitClick() {
        submitButton.click();
        return this;
    }

    public PracticeFormPage checkResult(String key, String value)
    {
        resultTable.checkResult(key,value);
        return this;
    }

    public PracticeFormPage checkNoTable()
    {
        resultTable.checkNoTable();
        return this;
    }
}
