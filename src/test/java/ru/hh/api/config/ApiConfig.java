package ru.hh.api.config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:properties/api.properties"
})

public interface ApiConfig extends Config {
    @Key("baseApiUrl")
    @DefaultValue("https://demowebshop.tricentis.com")
    String getBaseApiUrl();
}