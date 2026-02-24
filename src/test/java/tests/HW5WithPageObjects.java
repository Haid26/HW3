package tests;

import com.codeborne.selenide.logevents.SelenideLogger;
import com.github.javafaker.Faker;
import io.qameta.allure.Step;
import io.qameta.allure.Story;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.PracticeFormPage;
import utils.RandomUtils;

import java.util.ArrayList;

import static io.qameta.allure.Allure.step;

@Story("Registration form test")
public class HW5WithPageObjects extends TestBase {

    PracticeFormPage practiceFormPage = new PracticeFormPage();

    static String firstname, lastname, useremail, usernumber, useradress, gender, state, city, image, fileurl, day, month, year;
    String[] hobbies, subjects;

    @Test
    @DisplayName("Successful full registration")
    void successfulPracticeFormPageTest() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());

        step("Generate random data", () -> {
            firstname = RandomUtils.getRandomFirstName();
            lastname = RandomUtils.getRandomLastName();
            useremail = RandomUtils.getRandomEmail();
            usernumber = RandomUtils.getRandomNumber();
            useradress = RandomUtils.getRandomAdress();
            gender = RandomUtils.getRandomGender();
            hobbies = RandomUtils.getRandomHobbie();
            subjects = RandomUtils.getRandomSubjects();
            state = RandomUtils.getRandomState();
            city = RandomUtils.getRandomCity(state);
            image = RandomUtils.getRandomImage();
            fileurl = "images/" + image;
            day = RandomUtils.getRandomDay();
            month = RandomUtils.getRandomMonth();
            year = "" + RandomUtils.getRandomYear();
        });

        step("Open registration page", () ->
                practiceFormPage.openPage()
        );
        step("Fill registration form", () -> {
            practiceFormPage.setFirstName(firstname)
                    .setLastName(lastname)
                    .setGender(gender)
                    .setUserEmail(useremail)
                    .setUserNumber(usernumber)
                    .setHobbie(hobbies[0])
                    .setHobbie(hobbies[1])
                    .setHobbie(hobbies[2])
                    .setUserAdress(useradress)
                    .setSubject(subjects[0])
                    .setSubject(subjects[1])
                    .setSubject(subjects[2])
                    .setState(state)
                    .setCity(city)
                    .uploadPicture(fileurl)
                    .setDateOfBirth(day, month, year)
                    .submitClick();
        });

        step("Assertion data in table", () -> {
            practiceFormPage.checkResult("Student Name", firstname + " " + lastname)
                    .checkResult("Student Email", useremail)
                    .checkResult("Gender", gender)
                    .checkResult("Mobile", usernumber)
                    .checkResult("Date of Birth", day + " " + month + "," + year)
                    .checkResult("Subjects", subjects[3])
                    .checkResult("Hobbies", hobbies[3])
                    .checkResult("Picture", image)
                    .checkResult("Address", useradress)
                    .checkResult("State and City", state + " " + city);

        });
    }

    @Test
    @DisplayName("Successful short registration")
    void minValuePracticeFormPageTest() {

        step("Generate test data", () -> {
            firstname = RandomUtils.getRandomFirstName();
            lastname = RandomUtils.getRandomLastName();
            usernumber = RandomUtils.getRandomNumber();
            gender = RandomUtils.getRandomGender();
            day = RandomUtils.getRandomDay();
            month = RandomUtils.getRandomMonth();
            year = "" + RandomUtils.getRandomYear();
        });

        step("Open registration form page", () ->
                practiceFormPage.openPage()
        );
        step("Fill registration form", () -> {
            practiceFormPage.setFirstName(firstname)
                    .setLastName(lastname)
                    .setGender(gender)
                    .setUserNumber(usernumber)
                    .setDateOfBirth(day, month, year)
                    .submitClick();
        });
        step("Compare data", () -> {
            practiceFormPage.checkResult("Student Name", firstname + " " + lastname)
                    .checkResult("Gender", gender)
                    .checkResult("Mobile", usernumber)
                    .checkResult("Date of Birth", day + " " + month + "," + year);
        });
    }

    @Test
    @DisplayName("Negative test check mandatory field validation")
    void validationTest() {

        step("Open page", () ->
                practiceFormPage.openPage()
        );
        step("Send emtpy form", () ->
                practiceFormPage.submitClick()
        );
        step("Check that there is no table with data", () ->
                practiceFormPage.checkNoTable()
        );
    }
}
