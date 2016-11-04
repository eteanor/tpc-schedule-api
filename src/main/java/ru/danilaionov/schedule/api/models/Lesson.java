package ru.danilaionov.schedule.api.models;

/**
 * Created by Danila Ionov on 11/4/2016.
 */
public class Lesson {

    private int number;
    private String name;

    public Lesson() {

    }

    public Lesson(int number, String name) {
        this.number = number;
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
