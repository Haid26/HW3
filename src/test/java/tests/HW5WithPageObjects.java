package tests;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;
import pages.PracticeFormPage;
import utils.RandomUtils;


public class HW5WithPageObjects extends  TestBase{

    PracticeFormPage practiceFormPage = new PracticeFormPage();

    static String firstname, lastname, useremail, usernumber, useradress, gender, state, city, image, fileurl, day, month, year;


    @Test
    void successfulPracticeFormPageTest(){
        firstname =  RandomUtils.getRandomFirstName();
        lastname = RandomUtils.getRandomLastName();
        useremail = RandomUtils.getRandomEmail();
        usernumber = RandomUtils.getRandomNumber();
        useradress = RandomUtils.getRandomAdress();
        gender = RandomUtils.getRandomGender();
        String[] hobbies =  RandomUtils.getRandomHobbie();
        String [] subjects = RandomUtils.getRandomSubjects();
        state = RandomUtils.getRandomState();
        city = RandomUtils.getRandomCity(state);
        image = RandomUtils.getRandomImage();
        fileurl = "images\\"+ image;
        day = RandomUtils.getRandomDay();
        month = RandomUtils.getRandomMonth();
        year = ""+RandomUtils.getRandomYear();


        practiceFormPage.openPage()
                .hideBanners()
                .setFirstName(firstname)
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
                .setDateOfBirth(day,month,year)
                .submitClick();


        // Ok lets compare data
        practiceFormPage.checkResult("Student Name",firstname+" "+lastname)
                        .checkResult("Student Email",useremail)
                        .checkResult("Gender",gender)
                        .checkResult("Mobile",usernumber)
                        .checkResult("Date of Birth",day+" "+month+","+year)
                        .checkResult("Subjects",subjects[3])
                        .checkResult("Hobbies",hobbies[3])
                        .checkResult("Picture",image )
                        .checkResult("Address",useradress)
                        .checkResult("State and City",state+" "+city);

        //sleep(3000);
    }

    @Test
    void minValuePracticeFormPageTest(){
        firstname =  RandomUtils.getRandomFirstName();
        lastname = RandomUtils.getRandomLastName();
        usernumber = RandomUtils.getRandomNumber();
        gender = RandomUtils.getRandomGender();
        day = RandomUtils.getRandomDay();
        month = RandomUtils.getRandomMonth();
        year = ""+RandomUtils.getRandomYear();


        practiceFormPage.openPage()
                .hideBanners()
                .setFirstName(firstname)
                .setLastName(lastname)
                .setGender(gender)
                .setUserNumber(usernumber)
                .setDateOfBirth(day,month,year)
                .submitClick();



        practiceFormPage.checkResult("Student Name",firstname+" "+lastname)
                .checkResult("Gender",gender)
                .checkResult("Mobile",usernumber)
                .checkResult("Date of Birth",day+" "+month+","+year);
        //sleep(3000);
    }

    //проверка если сразу тыкнуть submit
    @Test
    void validationTest(){


        practiceFormPage.openPage()
                .hideBanners()
                .submitClick();


        // Ok lets compare data
        practiceFormPage.checkNoTable();

        //sleep(3000);
    }
}
