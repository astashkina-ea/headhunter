package ru.hh.data.enums;

public enum WorkSchedule {

    FULL_DAY("Полный день", "fullDay"),
    SHIFT("Сменный график", "shift"),
    FLY_IN_FLY_OUT("Вахтовый метод", "flyInFlyOut"),
    REMOTE("Удаленная работа", "remote"),
    FLEXIBLE("Гибкий график", "flexible");

    private String name;
    private String selector;

    WorkSchedule(String name, String selector) {
        this.name = name;
        this.selector = selector;
    }

    public String getSelector() {
        return selector;
    }

    @Override
    public String toString() {
        return name;
    }
}