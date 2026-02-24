package tests;

import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Test;
import pages.PracticeFormPage;
import pages.TextBoxPage;
import utils.RandomUtils;

import static com.codeborne.selenide.Selenide.sleep;
import static io.qameta.allure.Allure.step;

@Feature("Textbox page tests")
public class TextBoxPageTetst extends TestBase {
    TextBoxPage textBoxPage = new TextBoxPage();
    static String fullName, email, currentAddress, permanentAddress;

    @Test
    public void TextBoxPagePositiveTest() {

        step("Generate random data", () -> {
            fullName = RandomUtils.getRandomFirstName() + RandomUtils.getRandomLastName();
            email = RandomUtils.getRandomEmail();
            currentAddress = RandomUtils.getRandomAdress();
            permanentAddress = RandomUtils.getRandomAdress();
        });

        step("Open TextBox page", () ->
                textBoxPage.openPage()
        );
        step("Fill all fields", () ->
                textBoxPage.setFullName(fullName)
                        .setEmail(email)
                        .setCurrentAddress(currentAddress)
                        .setPermanentAddress(permanentAddress)
                        .submitClick()
        );
        step("Check data", () ->
                textBoxPage.checkOutput("name", fullName)
                        .checkOutput("email", email)
                        .checkOutput("currentAddress", currentAddress)
                        .checkOutput("permanentAddress", permanentAddress)
        );
    }
}
