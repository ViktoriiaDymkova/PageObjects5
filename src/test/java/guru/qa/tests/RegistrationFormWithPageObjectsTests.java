package guru.qa.tests;

import com.codeborne.selenide.Configuration;
import guru.qa.pages.RegistrationFormPage;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static java.lang.String.format;


public class RegistrationFormWithPageObjectsTests {

    RegistrationFormPage registrationFormPage = new RegistrationFormPage();

    String firstName = "vika",
    lastName = "kom",
    userEmail = "vika@kom.com",
    genter = "Female",
    phone = "1234567890",
    month = "July",
    year = "1991",
    day = "11",
    subject = "English",
    hobbie = "Music",
    currentAddress = "Spb",
    state = "NCR",
    city = "Delhi";
    String expectedFullName = format("%s %s", firstName, lastName);


    @BeforeAll
    static void beforeAll() {
        Configuration.holdBrowserOpen = true;
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
    }
    @Test
    void fillFormTest() {

        registrationFormPage.openPage();
        registrationFormPage.setFirstName(firstName)
                .setlastName(lastName)
                .setUserEmail(userEmail)
                .setGender(genter)
                .setPhoneNumber(phone)
                .setBirthDate(month, year, day)
                .setSubject(subject)
                .setHobbies(hobbie)
                .upLoadPicture()
                .getCurrentAddress(currentAddress)
                .setState(state)
                .setCity(city)
                .setsubmit();
        registrationFormPage.checkPracticeForm();
        registrationFormPage.checkResult("Student Name",expectedFullName);
    }
}