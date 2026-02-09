package pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class CalendarComponent {
    private static SelenideElement  calendarMonth =  $(".react-datepicker__month-select"),
            calendarYear =$(".react-datepicker__year-select");
    public void setDate(String day, String month, String year) {
        calendarMonth.click();
        calendarMonth.selectOption(month);
        calendarYear.selectOption(year);
        calendarYear.click();
        $(".react-datepicker__day--0" +day+":not(.react-datepicker__day--outside-month)").click();
    }
}
