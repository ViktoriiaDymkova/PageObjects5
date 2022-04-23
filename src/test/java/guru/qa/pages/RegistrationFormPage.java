package guru.qa.pages;

import com.codeborne.selenide.SelenideElement;
import guru.qa.pages.components.CalendarComponent;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationFormPage {
    CalendarComponent calendar = new CalendarComponent();

    //locators
SelenideElement firstNameInput = $("#firstName"),
            lastNameImput =  $("#lastName"),
            userEmailImput= $("#userEmail");




    //actions
    public RegistrationFormPage openPage(){
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
        zoom(0.65);
        return this;
    }

    public RegistrationFormPage setFirstName(String value){
        firstNameInput.setValue(value);
        return this;
    }
    public RegistrationFormPage setlastName(String value){
        lastNameImput.setValue(value);
        return this;
    }
    public RegistrationFormPage setUserEmail(String value){
        userEmailImput.setValue(value);
        return this;
    }
    public RegistrationFormPage setGender(String value){
        $("#genterWrapper").$(byText(value)).click();
        return this;
    }
    public RegistrationFormPage setPhoneNumber(String value) {
        $("[id=userNumber]").setValue(value);
        return this;
    }

    public RegistrationFormPage setBirthDate(String month, String year, String day){
        $("#dateOfBirthInput").click();
        calendar.setDate(month, year, day);
        return this;
    }

    public RegistrationFormPage setSubject(String value) {
        $("#subjectsInput").setValue(value).pressEnter();
        return this;
    }

    public RegistrationFormPage setHobbies (String Music){
    $("#hobbiesWrapper").$(byText(Music)).click();
   return this;
}
    public RegistrationFormPage upLoadPicture (){
        $("#uploadPicture").uploadFromClasspath("bruss.jpeg");
        return this;
    }
    public RegistrationFormPage getCurrentAddress (String value){
        $("#currentAddress").setValue(value);
        return this;
    }
    public RegistrationFormPage setState (String value){
        $("#state").click();
        $("#stateCity-wrapper").$(byText(value)).click();
        return this;
    }
    public RegistrationFormPage setCity (String value){
        $("#city").click();
        $("#stateCity-wrapper").$(byText(value)).click();
        return this;
    }
    public RegistrationFormPage setsubmit() {
        $("#submit").click();
        return this;
    }

   public RegistrationFormPage checkPracticeForm(){
       $("#example-modal-sizes-title-lg")
               .shouldHave(text("Thanks for submitting the form"));
       return this;
    }
    public RegistrationFormPage checkResult(String key, String value){
        $(".table-responsive").$(byText(key))
            .parent().shouldHave(text(value));
        return this;
    }
}