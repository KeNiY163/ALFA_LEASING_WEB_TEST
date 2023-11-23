package config;

import com.codeborne.selenide.Configuration;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.Map;


public class WebConfigProject {
    private final WebConfig webConfig;

    public WebConfigProject(WebConfig webConfig) {
        this.webConfig = webConfig;
    }
    public void webConfig() {
        Configuration.baseUrl = webConfig.getBaseURL();
        Configuration.browser = webConfig.getBrowserName().toString();
        Configuration.browserVersion = webConfig.getBrowserVersion();
        Configuration.browserSize = webConfig.getBrowserSize();
        Configuration.pageLoadStrategy = "eager";

        if (webConfig.isRemote()) {
            Configuration.remote = webConfig.getRemoteURL();

            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("selenoid:options", Map.<String, Object>of(
                    "enableVNC", true,
                    "enableVideo", true
            ));

            Configuration.browserCapabilities = capabilities;
        }
    }
}
