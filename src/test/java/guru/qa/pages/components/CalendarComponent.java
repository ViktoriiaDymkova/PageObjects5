package guru.qa.pages.components;

import static com.codeborne.selenide.Selectors.by;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class CalendarComponent {
public void setDate(String month, String year, String day){
    $("#dateOfBirthInput").click();
    $(".react-datepicker__month-select").selectOption(month);
    $(".react-datepicker__year-select").selectOption(year);
    $(".react-datepicker__day--0" + day +
            ":not(.react-datepicker__day--outside-month)").click();
    }
}
