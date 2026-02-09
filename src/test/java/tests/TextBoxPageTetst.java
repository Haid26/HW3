package tests;

import org.junit.jupiter.api.Test;
import pages.PracticeFormPage;
import pages.TextBoxPage;

import static com.codeborne.selenide.Selenide.sleep;

public class TextBoxPageTetst extends TestBase{
    TextBoxPage textBoxPage = new TextBoxPage();
    static String fullName, email, currentAddress, permanentAddress;

    @Test
    public void textBoxPagePositiveTest(){
        fullName = "Joe Testerson";
        email = "Joe@Tester.son";
        currentAddress = "Улица Пушкина дом Колотушкина";
        permanentAddress = "Улица Колотушкина дом Пушкина";
        textBoxPage.openPage()
                .hideBanners()
                .setFullName(fullName)
                .setEmail(email)
                .setCurrentAddress(currentAddress)
                .setPermanentAddress(permanentAddress)
                .submitClick();

        textBoxPage.checkOutput("name",fullName)
                .checkOutput("email",email)
                .checkOutput("currentAddress",currentAddress)
                .checkOutput("permanentAddress",permanentAddress);
    }
}
