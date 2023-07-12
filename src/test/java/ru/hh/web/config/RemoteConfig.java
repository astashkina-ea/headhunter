package ru.hh.web.config;

import org.aeonbits.owner.Config;

public interface RemoteConfig extends Config{

    @Config.Key("remoteUrl")
    String remoteURL();

    @Config.Key("loginRemote")
    String loginRemote();

    @Config.Key("passwordRemote")
    String passwordRemote();
}