import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;



public class AppOrderTest {
    @Test
    void TestNameOnlyOneWord(){
        open("http://localhost:9999");
        SelenideElement form = $("#root");
        form.$("[data-test-id='name'] .input__control").setValue("Q");
        form.$("[data-test-id='phone'] .input__control").setValue("+79094537420");
        form.$(".checkbox__box").click();
        form.$("[type='button']").click();
        $("[data-test-id='order-success'] span").shouldNotHave(exactText("Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время."));
    }
}
