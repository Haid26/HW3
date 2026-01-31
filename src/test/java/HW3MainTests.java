import org.junit.jupiter.api.*;


import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;


public class HW3MainTests  {


    @Test
    void mainTest(){
        open("https://demoqa.com/automation-practice-form");
        //$("#firstName").shouldHave(type("text"));

       $("#firstName").setValue("John");
        $("#lastName").setValue("Testerson");
        $("#userEmail").setValue("John@tester.son");
        $("#userNumber").setValue("1234567890");
        $("#dateOfBirthInput").setValue("31 Jan 1990");

        sleep(2000);


    }

}

