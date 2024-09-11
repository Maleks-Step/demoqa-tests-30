import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TextBoxTests {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
        Configuration.holdBrowserOpen = true;
    }


    @Test
    void fillFormTest() {
        open("/automation-practice-form");
        $("#firstName").setValue("User");
        $("#lastName").setValue("AM");
        $("#userEmail").setValue("invalid@mail.ru");
        $("#genterWrapper").find(".custom-control-label").click();
        $("#userNumber").setValue("8332223223");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").click();
        $(byText("February")).click();
        $(".react-datepicker__year-select").click();
        $(byText("1960")).click();
        $(".react-datepicker__month").click();
        $(byText("20")).click();
        $("#subjectsInput").setValue("Biology").pressEnter();
        $(byText("Music")).click();
        $(byText("Sports")).click();
        $("#uploadPicture").uploadFromClasspath("forTest.jpg");
        $("#currentAddress").setValue("221 B Street");
        $("#state").click();
        $("#react-select-3-option-0").click();
        $("#city").click();
        $("#react-select-4-option-1").click();
        $("#submit").click();


        $(".table-responsive").shouldHave(text("User AM"));
        $(".table-responsive").shouldHave(text("invalid@mail.ru"));
        $(".table-responsive").shouldHave(text("Male"));
        $(".table-responsive").shouldHave(text("8332223223"));
        $(".table-responsive").shouldHave(text("20 February,1960"));
        $(".table-responsive").shouldHave(text("Biology"));
        $(".table-responsive").shouldHave(text("Music"));
        $(".table-responsive").shouldHave(text("Sports"));
        $(".table-responsive").shouldHave(text("forTest.jpg"));
        $(".table-responsive").shouldHave(text("221 B Street"));
        $(".table-responsive").shouldHave(text("NCR Gurgaon"));
    }
}
