package ru.hh.config;

import org.aeonbits.owner.Config;

public interface RemoteConfig extends Config{

    @Config.Key("selenoid.url")
    String url();

    @Config.Key("selenoid.login")
    String login();

    @Config.Key("selenoid.password")
    String password();
}