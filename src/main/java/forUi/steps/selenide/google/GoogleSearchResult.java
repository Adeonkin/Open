package forUi.steps.selenide.google;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Condition.*;

public class GoogleSearchResult extends GoogleMainPage {

    public void checkResultAndOpenSite(String checkSite) {
        elements("#search .g").first().shouldHave(text(checkSite));
        $(byText(checkSite)).click();
    }
}
