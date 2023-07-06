package ru.hh.api.data.enums;

public enum TypeErrors {

    FORBIDDEN("forbidden");

    private String text;

    TypeErrors(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}
