package ru.hh.api.utils;

import com.github.javafaker.Faker;

import java.util.List;

public class RandomUtils {

    private static Faker faker = new Faker();

    public static int getRandomBetweenNumber(int min, int max) {
        return faker.random().nextInt(min, max);
    }

    public static String getRandomText() {
        return faker.harryPotter().quote();
    }

    public static <T> T getRandomElementFromList(List<T> list) {
        int index = getRandomBetweenNumber(0, list.size() - 1);
        return list.get(index);
    }
}
