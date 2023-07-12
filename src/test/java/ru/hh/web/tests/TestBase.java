package ru.hh.web.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import org.aeonbits.owner.ConfigFactory;
import ru.hh.web.config.RemoteConfig;
import ru.hh.web.config.WebDriverConfig;
import ru.hh.web.helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.Map;

import static com.codeborne.selenide.Selenide.closeWebDriver;

public class TestBase {

    public static WebDriverConfig webDriverConfig = ConfigFactory.create(WebDriverConfig.class, System.getProperties());
    public static RemoteConfig remoteConfig = ConfigFactory.create(RemoteConfig.class, System.getProperties());

    @BeforeAll
    static void beforeAll() {

        Configuration.pageLoadStrategy = "eager";
        Configuration.baseUrl = webDriverConfig.getBaseUrl();
        Configuration.browser = webDriverConfig.browser();
        Configuration.browserVersion = webDriverConfig.browserVersion();
        Configuration.browserSize = webDriverConfig.browserSize();

        if (remoteConfig.remoteURL() != null && remoteConfig.passwordRemote() != null && remoteConfig.loginRemote() != null) {
            Configuration.remote = String.format("https://%s:%s@%s/wd/hub", remoteConfig.loginRemote(), remoteConfig.passwordRemote(), remoteConfig.remoteURL());
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("selenoid:options", Map.<String, Object>of(
                    "enableVNC", true,
                    "enableVideo", true
            ));
            Configuration.browserCapabilities = capabilities;
        }
    }

    @BeforeEach
    void beforeEach() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
    }

    @AfterEach
    void addAttachments() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        if (remoteConfig.remoteURL() != null && remoteConfig.passwordRemote() != null && remoteConfig.loginRemote() != null) {
            Attach.addVideo();
        }
        closeWebDriver();
    }
}