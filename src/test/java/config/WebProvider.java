package config;

import com.codeborne.selenide.Configuration;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.Map;
import java.util.function.Supplier;

public class WebProvider implements Supplier<WebDriver> {
    private final WebDriverConfig config;

    public WebProvider(WebDriverConfig config) {
        this.config = config;
    }

    @Override
    public WebDriver get() {
        WebDriver driver = createWebDriver();
        driver.get(config.getBaseUrl());

        return driver;
    }

    public WebDriver createWebDriver() {
        switch (config.getBrowserName()) {
            case CHROME: {
                WebDriverManager.chromedriver().setup();

                return new ChromeDriver();
            }
            case FIREFOX: {
                WebDriverManager.firefoxdriver().setup();

                return new FirefoxDriver();
            }
            default: {
                throw new RuntimeException("No such driver");
            }
        }
    }

    public void webConfiguration() {
        Configuration.baseUrl = config.getBaseUrl();
        Configuration.browser = config.getBrowserName().toString();
        Configuration.browserVersion = config.getBrowserVersion();
        Configuration.browserSize = config.getBrowserSize();
        Configuration.pageLoadStrategy = "eager";

        Configuration.holdBrowserOpen = true;

        Configuration.remote = config.isRemote().toString();

        if (config.isRemote()) {
            Configuration.remote = config.getRemoteUrl();
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("selenoid:options", Map.<String, Object>of(
                    "enableVNC", true,
                    "enableVideo", true
            ));

            Configuration.browserCapabilities = capabilities;
        }
    }
}
