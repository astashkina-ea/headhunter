package ru.hh.config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:credentials.properties"
})

public interface CredentialsConfig extends Config{
    @Key("loginAccount")
    String getLoginAccount();

    @Key("passwordAccount")
    String getPasswordAccount();
}
