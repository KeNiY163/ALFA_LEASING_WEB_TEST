package utils;


import com.codeborne.selenide.logevents.SelenideLogger;
import config.WebConfig;
import config.WebConfigProject;
import helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import static com.codeborne.selenide.Selenide.closeWebDriver;

public class BaseTest {

    protected static final WebConfig config = ConfigFactory.create(WebConfig.class, System.getProperties());

    @BeforeAll
    static void beforeAll() {
        WebConfigProject webConfigProject = new WebConfigProject(config);
        webConfigProject.webConfig();
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
        Attach.addVideo();

        closeWebDriver();

    }
}
