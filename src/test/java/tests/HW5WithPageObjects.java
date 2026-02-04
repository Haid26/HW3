package tests;

import org.junit.jupiter.api.Test;
import pages.PracticeFormPage;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class HW5WithPageObjects extends  TestBase{

    PracticeFormPage practiceFormPage = new PracticeFormPage();

    static String firstname, lastname, useremail, usernumber, useradress, gender, hobbie1, hobbie2, subject1, subject2, state, city, fileurl, bday, bmonth, byear;


    @Test
    void successfulPracticeFormPageTest(){
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
        fileurl = "cat.jpg";
        bday = "02";
        bmonth="May";
        byear= "1994";


        practiceFormPage.openPage()
                .hideBanners()
                .setFirstName(firstname)
                .setLastName(lastname)
                .setGender(gender)
                .setUserEmail(useremail)
                .setUserNumber(usernumber)
                .setHobbie(hobbie1)
                .setHobbie(hobbie2)
                .setUserAdress(useradress)
                .setSubject(subject1)
                .setSubject(subject2)
                .setState(state)
                .setCity(city)
                .uploadPicture("images\\"+fileurl)
                .setDateOfBirth(bday,bmonth,byear)
                .submitClick();


        // Ok lets compare data
        practiceFormPage.checkResult("Student Name",firstname+" "+lastname)
                        .checkResult("Student Email",useremail)
                        .checkResult("Gender",gender)
                        .checkResult("Mobile",usernumber)
                        .checkResult("Date of Birth",bday+" "+bmonth+","+byear)
                        .checkResult("Subjects",subject1+", "+subject2)
                        .checkResult("Hobbies",hobbie1+", "+hobbie2)
                        .checkResult("Picture",fileurl)
                        .checkResult("Address",useradress)
                        .checkResult("State and City",state+" "+city);

        //sleep(3000);
    }

    @Test
    void MinValuePracticeFormPageTest(){
        firstname =  "John";
        lastname = "Testerson";
        usernumber = "1234567890";
        gender = "Male";
        bday = "02";
        bmonth="May";
        byear= "1994";


        practiceFormPage.openPage()
                .hideBanners()
                .setFirstName(firstname)
                .setLastName(lastname)
                .setGender(gender)
                .setUserNumber(usernumber)
                .setDateOfBirth(bday,bmonth,byear)
                .submitClick();


        // Ok lets compare data
        practiceFormPage.checkResult("Student Name",firstname+" "+lastname)
                .checkResult("Gender",gender)
                .checkResult("Mobile",usernumber)
                .checkResult("Date of Birth",bday+" "+bmonth+","+byear);
        //sleep(3000);
    }

    //проверка если сразу тыкнуть submit
    @Test
    void ValidationTest(){


        practiceFormPage.openPage()
                .hideBanners()
                .submitClick();


        // Ok lets compare data
        practiceFormPage.checkNoTable();

        //sleep(3000);
    }
}
