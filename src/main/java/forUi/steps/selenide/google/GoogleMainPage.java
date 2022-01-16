package forUi.steps.selenide.google;

import forUi.steps.selenide.BasePage;

import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selenide.element;
import static com.codeborne.selenide.Selenide.open;

public class GoogleMainPage extends BasePage {

    public void openGoogle() {
        open("https://www.google.com/");
    }

    public void findText(String text) {
        element(byName("q")).setValue(text).pressEnter();
    }
}
