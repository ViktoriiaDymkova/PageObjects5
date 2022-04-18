package guru.qa.tests;

import com.codeborne.selenide.Configuration;
import com.github.javafaker.Faker;
import guru.qa.pages.RegistrationFormPage;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Selenide.*;
import static java.lang.String.format;


public class RegistrationFormWithFakerTests {

    RegistrationFormPage registrationFormPage = new RegistrationFormPage();

    Faker faker = new Faker();

    String firstName = faker.name().firstName();
    String lastName = faker.name().lastName();
    String userEmail = faker.internet().emailAddress();
    String genter = "Female";
    String phone = "1234567891";
    String month = "July";
    String year = "1991";
    String day = "11";
    String subject = "English";
    String hobbie = "Music";
    String currentAddress = faker.address().fullAddress();
    String state = "NCR";
    String city = "Delhi";
    String expectedFullName = format("%s %s", firstName, lastName);


    @BeforeAll
    static void beforeAll() {
        Configuration.holdBrowserOpen = true;
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
        open("/automation-practice-form");
        zoom(0.65);
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


