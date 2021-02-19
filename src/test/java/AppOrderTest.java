import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;



public class AppOrderTest {
    @Test
    void CorrectTest(){

        Configuration.headless = true;

        open("http://localhost:9999");
        SelenideElement form = $("#root");
        form.$("[data-test-id='name'] .input__control").setValue("Иванов Василий Иванович");
        form.$("[data-test-id='phone'] .input__control").setValue("+79094537420");
        form.$(".checkbox__box").click();
        form.$("[type='button']").click();
        $("[data-test-id='order-success']").shouldHave(exactText("Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время."));
    }

    @Test
    void InCorrectNameTest(){

        Configuration.headless = true;

        open("http://localhost:9999");
        SelenideElement form = $("#root");
        form.$("[data-test-id='name'] .input__control").setValue("Ivanov Vasiliy Ivanovich");
        form.$("[data-test-id='phone'] .input__control").setValue("+79094537420");
        form.$(".checkbox__box").click();
        form.$("[type='button']").click();
  //      String text = form.$("[data-test-id='name'] .input__sub").getAttribute("text");
        $("[data-test-id='name'] .input__sub").shouldHave(exactText("Имя и Фамилия указаные неверно. Допустимы только русские буквы, пробелы и дефисы."));
    }
}
