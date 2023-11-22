package config;

import com.codeborne.selenide.Configuration;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.Map;


public class WebProvider {
    private final WebDriverConfig config;

    public WebProvider(WebDriverConfig config) {
        this.config = config;
    }

    public void webConfiguration() {
        Configuration.baseUrl = config.getBaseUrl();
        Configuration.browser = config.getBrowserName().toString();
        Configuration.browserVersion = config.getBrowserVersion();
        Configuration.browserSize = config.getBrowserSize();
        Configuration.pageLoadStrategy = "eager";

        if (config.isRemote()) {
            Configuration.remote = config.getRemoteURL();

            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("selenoid:options", Map.<String, Object>of(
                    "enableVNC", true,
                    "enableVideo", true
            ));

            Configuration.browserCapabilities = capabilities;
        }
    }
}
