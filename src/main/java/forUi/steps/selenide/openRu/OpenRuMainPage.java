package forUi.steps.selenide.openRu;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import forUi.steps.selenide.BasePage;
import org.openqa.selenium.By;
import org.testng.Assert;

import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.title;

public class OpenRuMainPage extends BasePage {

    private final String BANK_BUY = "Банк покупает";
    private final String BANK_SELL = "Банк продает";
    private final String BUY_COURSE = "Курс покупки ";

    public void checkSiteName () {
        Assert.assertEquals(title(), "Частным клиентам | Банк Открытие");
    }

    private float getCourse(String currency, String typeOperation) {
        ElementsCollection trHeaders = $$(By.xpath("//*[@class='main-page-exchange__table-header']/td"));
        ElementsCollection trRows = $$(By.xpath("//*[contains(@class,'exchange__row')]"));
        SelenideElement elemPrice = null;
        for (int i = 0; i < trHeaders.size(); ++i) {
            if (trHeaders.get(i).getText().equals(typeOperation)) {
                elemPrice = trRows.find(Condition.matchText(currency)).$$x("./td").get(i);
                break;
            }
        }
        return Float.parseFloat(elemPrice.getText().replace(",", "."));
    }

    public OpenRuMainPage checkCurrencyRate(String currency) {
        Assert.assertTrue(
                getCourse(currency, BANK_BUY)
                        <
                        getCourse(currency, BANK_SELL),
                BUY_COURSE + currency + " не меньше курса продажи"
        );
        System.out.println(BUY_COURSE + currency + " " + getCourse(currency, BANK_BUY)
                + ", Курс продажи " + currency + " " + getCourse(currency, BANK_SELL));
        return this;
    }
}
