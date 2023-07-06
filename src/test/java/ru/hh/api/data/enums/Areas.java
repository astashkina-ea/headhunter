package ru.hh.api.data.enums;

public enum Areas {

    MSK("1", "Москва", "https://api.hh.ru/areas/1"),
    SPB("2", "Санкт-Петербург", "https://api.hh.ru/areas/2"),
    EKB("3", "Екатеринбург", "https://api.hh.ru/areas/3"),
    NSK("4", "Новосибирск", "https://api.hh.ru/areas/4"),
    PNZ("71", "Пенза", "https://api.hh.ru/areas/71");

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
        return url;
    }
}