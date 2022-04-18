package guru.qa.tests;

import com.codeborne.selenide.Configuration;
import guru.qa.pages.RegistrationFormPage;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static java.lang.String.format;


public class RegistrationFormWithPageObjectsTests {

    RegistrationFormPage registrationFormPage = new RegistrationFormPage();

    String firstName = "vika";
    String lastName = "kom";
    String userEmail = "vika@kom.com";
    String genter = "Female";
    String phone = "1234567890";
    String month = "July";
    String year = "1991";
    String day = "11";
    String subject = "English";
    String hobbie = "Music";
    String currentAddress = "Spb";
    String state = "NCR";
    String city = "Delhi";
    String expectedFullName = format("%s %s", firstName, lastName);


    @BeforeAll
    static void beforeAll() {
        Configuration.holdBrowserOpen = true;
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
    }
    @Test
    void fillFormTest() {

        registrationFormPage.openPage()
                .setFirstName(firstName)
                .setlastName(lastName)
                .setUserEmail(userEmail)
                .getGender(genter)
                .setPhoneNumber(phone)
                .setBirthDate(month, year, day)
                .setSubject(subject)
                .getHobbies(hobbie)
                .upLoadPicture()
                .getCurrentAddress(currentAddress)
                .setState(state)
                .setCity(city)
                .setsubmit();
        registrationFormPage.checkExample();
        registrationFormPage.checkResult("Student Name",expectedFullName);
    }
}