package forUi.steps.selenide;

import com.codeborne.selenide.Configuration;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeTest;

public class BasePage {
    @BeforeTest
    public  void option(){
        Configuration.timeout=6000;
        Configuration.browser="chrome";
        Configuration.browserSize="1920x1080";

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-extensions");

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(ChromeOptions.CAPABILITY, options);
        Configuration.browserCapabilities = capabilities;
    }
}
