package config;

import org.aeonbits.owner.Config;


@Config.Sources({
        "classpath:${env}.properties"
})

public interface WebDriverConfig extends Config {

    @Key("baseUrl")
    @DefaultValue("https://alfaleasing.ru/catalog/")
    String getBaseUrl();

    @Key("browserName")
    @DefaultValue("CHROME")
    Browser getBrowserName();

    @Key("browserVersion")
    @DefaultValue("116.0")
    String getBrowserVersion();

    @Key("browserSize")
    @DefaultValue("1920x1080")
    String getBrowserSize();

    @Key("remoteURL")
    String getRemoteURL();

    @Key("isRemote")
    @DefaultValue("false")
    Boolean isRemote();

}
