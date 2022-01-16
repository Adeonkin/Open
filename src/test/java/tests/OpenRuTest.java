package tests;

import forUi.steps.selenide.BasePage;
import forUi.steps.selenide.google.GoogleSearchResult;
import forUi.steps.selenide.openRu.OpenRuMainPage;
import org.testng.annotations.Test;

public class OpenRuTest extends BasePage {

    OpenRuMainPage openRuMainPage = new OpenRuMainPage();
    GoogleSearchResult googleSearchResult = new GoogleSearchResult();

    @Test
    public void currencyRateComparison() {
        googleSearchResult.openGoogle();
        googleSearchResult.findText("Открытие");
        googleSearchResult.checkResultAndOpenSite("https://www.open.ru");
        openRuMainPage.checkSiteName();
        openRuMainPage.checkCurrencyRate("USD");
        openRuMainPage.checkCurrencyRate("EUR");
    }
}