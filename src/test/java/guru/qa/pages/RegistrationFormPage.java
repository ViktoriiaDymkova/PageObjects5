package guru.qa.pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.github.javafaker.Faker;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationFormPage {
    //locators


    //actions
    public RegistrationFormPage openPage(){
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
        //executeJavaScript("$('footer').remote()");
        //executeJavaScript("$('#fixe').remote()");
        zoom(0.65);
        return this;
    }

    public RegistrationFormPage setFirstName(String value){
        $("#firstName").setValue(value);
        return this;
    }
    public RegistrationFormPage setlastName(String value){
        $("#lastName").setValue(value);
        return this;
    }
    public RegistrationFormPage setuserEmail(String value){
        $("#userEmail").setValue(value);
        return this;
    }
    public RegistrationFormPage setGender(String value){
        $("#genterWrapper").setValue(value);
        return this;
    }
    public RegistrationFormPage setPhoneNumber(String value) {
        $("#phone").setValue(value).click();
        return this;
    }

    public RegistrationFormPage setDateOfBirth(String month, String year, String day){
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption(month);
        $(".react-datepicker__year-select").selectOption(year);
        $(".react-datepicker__day--0" + day).click();
        return this;
    }

    public RegistrationFormPage setSubjects(String English) {
        $("#subjectsInput").setValue("English").pressEnter();
        return this;
    }



    public RegistrationFormPage getHobbies (String Music){
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

    public RegistrationFormPage checkExample(String header, String value) {
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        return this;
    }
    public RegistrationFormPage checkResult(String key, String value){
        $(".table-responsive").$(byText(key))
            .parent().shouldHave(text(value));
        return this;
    }
    }