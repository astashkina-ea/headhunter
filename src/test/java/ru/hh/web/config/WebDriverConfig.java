package ru.hh.web.config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:${environment}.properties"
})

public interface WebDriverConfig extends Config {
    @Key("baseUrl")
    @DefaultValue("https://hh.ru")
    String baseUrl();

    @Key("browser")
    @DefaultValue("chrome")
    String browser();

    @Key("browserVersion")
    @DefaultValue("100.0")
    String browserVersion();

    @Key("browserSize")
    @DefaultValue("1920x1080")
    String browserSize();
}