package ru.hh.data.enums;

import org.aeonbits.owner.ConfigFactory;
import ru.hh.config.ApiConfig;

public enum Areas {

    MSK("1", "Москва", "/areas/1"),
    SPB("2", "Санкт-Петербург", "/areas/2"),
    EKB("3", "Екатеринбург", "/areas/3"),
    NSK("4", "Новосибирск", "/areas/4"),
    PNZ("71", "Пенза", "/areas/71");

    private String id;
    private String name;
    private String url;

    Areas(String id, String name, String url) {
        this.id = id;
        this.name = name;
        this.url = url;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getUrl() {
        ApiConfig config = ConfigFactory.create(ApiConfig.class, System.getProperties());
        return config.getBaseApiUrl() + url;
    }
}