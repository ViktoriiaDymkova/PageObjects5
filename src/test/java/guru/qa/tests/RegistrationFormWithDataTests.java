package guru.qa.tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static java.lang.String.format;


public class RegistrationFormWithDataTests {
    String firstName = "vika",
            lastName = "kom",
            email = "vika@kom.com";
    String expectedFullName = format("%s %s", firstName, lastName);

    @BeforeAll
    static void beforeAll() {
        Configuration.holdBrowserOpen = true;
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
    }
/////это проверка
    @Test
    void fillFormTest() {
        open("/automation-practice-form");
        //executeJavaScript("$('footer').remote()");
        //executeJavaScript("$('#fixe').remote()");
        zoom(0.65);

        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
        $("[id=firstName]").setValue(firstName);
        $("[id=lastName]").setValue(lastName);
        $("[id=userEmail]").setValue(email);
        $("#genterWrapper").$(byText("Female")).click();
        $("[id=userNumber]").setValue("1234567890");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("July");
        $(".react-datepicker__year-select").selectOption("1991");
        $(".react-datepicker__day--011:not(.react-datepicker__day--outside-month)").click();
        $("#subjectsInput").setValue("English").pressEnter();
        $("#hobbiesWrapper").$(byText("Music")).click();
        $("#uploadPicture").uploadFromClasspath("bruss.jpeg");
        $("#currentAddress").setValue("Spb");
        $("#state").click();
        $("#stateCity-wrapper").$(byText("NCR")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Delhi")).click();
        $("#submit").click();
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
       $(".table-responsive").shouldHave(text(expectedFullName), text(email), text("Female"));
       $(".table-responsive").$(byText("Student Name"))
                .parent().shouldHave(text("vika kom"));
    }
}