package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.*;


import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;


public class HW3MainTests  {

    static String firstname, lastname, useremail, usernumber, useradress, gender, hobbie1, hobbie2, subject1, subject2, state, city;

    @BeforeAll
    static void beforeAll(){
        //Configuration.browserSize = "1920x1080";
        Configuration.baseUrl= "https://demoqa.com";
        Configuration.pageLoadStrategy="eager";
        //Configuration.holdBrowserOpen = true;
        Configuration.timeout = 5000;
        firstname =  "John";
        lastname = "Testerson";
        useremail = "John@tester.son";
        usernumber = "1234567890";
        useradress = "Улица Пушкина дом Колотушкина";
        hobbie1 = "Sports";
        hobbie2 = "Music";
        subject1 = "Maths";
        subject2 = "Accounting";
        state = "NCR";
        city = "Delhi";
        gender = "Male";

    }

    @Test
    void mainTest(){
        open("/automation-practice-form");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        //Simple forms
        $("#firstName").setValue(firstname);
        $("#lastName").setValue(lastname);
        $("#userEmail").setValue(useremail);
        $("[for =gender-radio-1]").click();
        $("#genterWrapper").$(byText(gender)).click();
        $("#userNumber").setValue(usernumber);
        $("#currentAddress").setValue(useradress);
        $("#hobbiesWrapper").$(byText(hobbie1)).click();
        $("#hobbiesWrapper").$(byText(hobbie2)).click();

        //Date
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").click();
        $(".react-datepicker__month-select").selectOptionByValue("4");
        $(".react-datepicker__year-select").click();
        $(".react-datepicker__year-select").selectOptionByValue("1994");
        $(".react-datepicker__year-select").click();
        $(".react-datepicker__day--002").click();

        //Subjects container
        $("#subjectsContainer").press("a");
        $("#subjectsContainer").$(byText(subject1)).click();
        $("#subjectsInput").press("a");
        $("#subjectsContainer").$(byText(subject2)).click();


        //State and City
        $("#state").click();
        $("#state").$(byText(state)).click();
        $("#city").click();
        $("#city").$(byText(city)).click();

        //File upload
        $("#uploadPicture").uploadFromClasspath("images\\cat.jpg");


        // all done, submit now
        $("#submit").click();

        // Ok lets compare data
        $(".modal-body").shouldHave(text("Student Name "+firstname+" "+lastname));
        $(".modal-body").shouldHave(text("Student Email "+useremail));
        $(".modal-body").shouldHave(text("Gender "+gender));
        $(".modal-body").shouldHave(text("Mobile "+usernumber));
        $(".modal-body").shouldHave(text("Date of Birth 02 May,1994"));
        $(".modal-body").shouldHave(text("Subjects "+subject1+", "+subject2));
        $(".modal-body").shouldHave(text("Hobbies "+hobbie1+", "+hobbie2));
        $(".modal-body").shouldHave(text("Picture cat.jpg"));
        $(".modal-body").shouldHave(text("Address "+useradress));
        $(".modal-body").shouldHave(text("State and City "+state+" "+city));




        sleep(3000);
    }

}

