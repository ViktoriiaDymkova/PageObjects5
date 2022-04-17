package guru.qa.tests;

import com.codeborne.selenide.Configuration;
import com.github.javafaker.Faker;
import guru.qa.pages.RegistrationFormPage;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;


public class RegistrationFormWithPageObjectsTests {
    RegistrationFormPage registrationFormPage = new RegistrationFormPage();
    String firstName = "vika";
    String lastName = "kom";
    String userEmail = "vika@kom.com";
    String genter = "Female";
    String phone = "1234567890";
    String subject = "English";
    String hobbie = "Music";
    String currentAddress = "Spb";
    String state = "NCR";
    String city = "Delhi";

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
                .setGender(genter)
                .setuserEmail(userEmail)
                .setPhoneNumber(phone)
                .setDateOfBirth("July","1991", "011" )
//        $(".react-datepicker__month-select").selectOption("July");
//        $(".react-datepicker__year-select").selectOption("1991");
//        $(".react-datepicker__day--011:not(.react-datepicker__day--outside-month)").click();
                .setSubjects(subject)
                .getHobbies(hobbie)
                .upLoadPicture()
                .getCurrentAddress(currentAddress)
                .setState(state)
                .setCity(city)
                .setsubmit();
    //       $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        registrationFormPage.checkExample("Thanks for submitting the form");
        registrationFormPage.checkResult("Student Name", "vika kom")
                .checkResult("Student Email", "vika@kom.com")
                .checkResult("Gender", "Female");
    }
}