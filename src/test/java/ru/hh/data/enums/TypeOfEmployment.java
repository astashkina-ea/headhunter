package ru.hh.data.enums;

public enum TypeOfEmployment {

    FULL("Полный день", "full"),
    PART("Сменный график", "part"),
    PROBATION("Вахтовый метод", "probation"),
    PROJECT("Удаленная работа", "project"),
    VOLUNTEER("Гибкий график", "volunteer");

    private String name;
    private String selector;

    TypeOfEmployment(String name, String selector) {
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