package config;

import org.aeonbits.owner.Config;


@Config.Sources({
        "classpath:${env}.properties"
})

public interface WebConfig extends Config {

    @Key("baseUrl")
    @DefaultValue("https://alfaleasing.ru/catalog")
    String getBaseURL();

    @Key("browserName")
    @DefaultValue("CHROME")
    Browser getBrowserName();

    @Key("browserVersion")
    @DefaultValue("110.0")
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
