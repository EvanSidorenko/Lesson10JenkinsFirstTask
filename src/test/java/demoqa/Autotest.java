package demoqa;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;


public class Autotest  extends TestData{
    @Test
    @Tag("autotest")
    @DisplayName("Successful registration test")
    void fillFormTest() {
        String firstName = "Thomas";
        String lastName = "Anderson";
        String userEmail = "neo@matrix.com";
        String userNumber = "9998887766";
        String address = "Liberty st, room 101";

        step("Open registration form", () -> {
            open("/automation-practice-form");
            $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
            executeJavaScript("$('footer').remove()");
            executeJavaScript("$('#fixedban').remove()");
        });

        step("Fill registration form", () -> {
            $("#firstName").setValue(firstName);
            $("#lastName").setValue(lastName);
            $("#userEmail").setValue(userEmail);
            $("#genterWrapper").$(byText("Male")).click();
            $("#userNumber").setValue(userNumber);
            $("#dateOfBirthInput").click();
            $(".react-datepicker__month-select").selectOptionByValue("0");
            $(".react-datepicker__year-select").selectOptionByValue("1992");
            $(".react-datepicker__day.react-datepicker__day--013").click();
            $("#subjectsInput").setValue("English").pressEnter();
            $("#hobbiesWrapper").$(byText("Reading")).click();
            $("#uploadPicture").uploadFromClasspath("download.jpg");
            $("#currentAddress").setValue(address);
            $("#state").click();
            $("#stateCity-wrapper").$(byText("Haryana")).click();
            $("#city").click();
            $("#stateCity-wrapper").$(byText("Karnal")).click();
            $("#submit").click();
        });

        step("Verify form data", () -> {
            $("#example-modal-sizes-title-lg").shouldHave(
                    text("Thanks for submitting the form"));
            $(".table-responsive").shouldHave(
                    text(firstName + " " + lastName),
                    text(userEmail),
                    text("Male"),
                    text("13 January,1992"),
                    text("English"),
                    text("Reading"),
                    text("download.jpg"),
                    text(address),
                    text("Haryana Karnal"));
        });
    }
}
