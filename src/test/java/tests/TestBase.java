package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import drivers.BrowserstackMobileDriver;
import drivers.LocalMobileDriver;
import helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import pages.HomepagePage;

import static com.codeborne.selenide.Selenide.*;
import static helpers.Attach.getSessionId;
import static io.restassured.RestAssured.sessionId;

public class TestBase {
    public static HomepagePage homepagePage = new HomepagePage();
    public static String deviceHost = System.getProperty("deviceHost");

    @BeforeAll
    public static void setDriver() {

        switch (deviceHost) {
            case "emulator":
                Configuration.browser = LocalMobileDriver.class.getName();
                break;
            case "browserstack":
                Configuration.browser = BrowserstackMobileDriver.class.getName();
                break;
        }
        Configuration.browserSize = null;
    }

    @BeforeEach
    void addListener() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
        open();
    }

    @AfterEach
    void afterEach() {
        String deviceHost = System.getProperty("deviceHost");
        String sessionId = getSessionId();

        Attach.pageSource();
        closeWebDriver();
        //Attach.screenshotAs("Last screenshot");
        if (deviceHost.equals("browserstack")) {
            Attach.addVideo(sessionId);
        }

    }
}
