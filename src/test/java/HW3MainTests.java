import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;


import java.io.File;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;


public class HW3MainTests  {

    static String firstname, lastname, useremail, usernumber, useradress;
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
    }

    @Test
    void mainTest(){
        open("/automation-practice-form");
        //Simple forms
        $("#firstName").setValue(firstname);
        $("#lastName").setValue(lastname);
        $("#userEmail").setValue(useremail);
        $("[for =gender-radio-1]").click();
        $("#userNumber").setValue(usernumber);
        $("#currentAddress").setValue(useradress);
        $("[for=hobbies-checkbox-1]").click();
        $("[for=hobbies-checkbox-2]").click();
        $("[for=hobbies-checkbox-3]").click();

        //Date
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").click();
        $(".react-datepicker__month-select").selectOptionByValue("4");
        $(".react-datepicker__year-select").click();
        $(".react-datepicker__year-select").selectOptionByValue("1994");
        $(".react-datepicker__year-select").click();
        $(".react-datepicker__day--002").click();

        //Subjects container
        $("#subjectsInput").press("a");
        $("#react-select-2-option-0").click();
        $("#subjectsInput").press("a");
        $("#react-select-2-option-2").click();

        //State and City
        $("#state").click();
        $("#react-select-3-option-0").click();
        $("#city").click();
        $("#react-select-4-option-0").click();

        //File upload
        $("#uploadPicture").uploadFile(new File("src\\test\\cat.jpg"));


        // all done, submit now
        $("#submit").click();

        // Ok lets compare data
        $(By.xpath("//*[@class='table-responsive']//tbody/tr[1]/td[2]")).shouldHave(exactText(firstname+" "+lastname));
        $(By.xpath("//*[@class='table-responsive']//tbody/tr[2]/td[2]")).shouldHave(exactText(useremail));
        $(By.xpath("//*[@class='table-responsive']//tbody/tr[3]/td[2]")).shouldHave(exactText("Male"));
        $(By.xpath("//*[@class='table-responsive']//tbody/tr[4]/td[2]")).shouldHave(exactText(usernumber));
        $(By.xpath("//*[@class='table-responsive']//tbody/tr[5]/td[2]")).shouldHave(exactText("02 May,1994"));
        $(By.xpath("//*[@class='table-responsive']//tbody/tr[6]/td[2]")).shouldHave(exactText("Maths, Arts"));
        $(By.xpath("//*[@class='table-responsive']//tbody/tr[7]/td[2]")).shouldHave(exactText("Sports, Reading, Music"));
        $(By.xpath("//*[@class='table-responsive']//tbody/tr[8]/td[2]")).shouldHave(exactText("cat.jpg"));
        $(By.xpath("//*[@class='table-responsive']//tbody/tr[9]/td[2]")).shouldHave(exactText(useradress));
        $(By.xpath("//*[@class='table-responsive']//tbody/tr[10]/td[2]")).shouldHave(exactText("NCR Delhi"));




        sleep(3000);
    }

}

