package ru.hh.config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:properties/test.properties"
})

public interface ApiConfig extends Config {
    @Key("baseApiUrl")
    @DefaultValue("https://api.hh.ru")
    String baseApiUrl();
}