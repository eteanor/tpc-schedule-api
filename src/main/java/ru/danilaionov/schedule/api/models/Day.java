package ru.danilaionov.schedule.api.models;

import java.util.List;

/**
 * Created by Danila Ionov on 11/4/2016.
 */
public class Day {

    private int number;
    private List<Lesson> lessons;

    public Day() {
    }

    public Day(int number, List<Lesson> lessons) {
        this.number = number;
        this.lessons = lessons;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public List<Lesson> getLessons() {
        return lessons;
    }

    public void setLessons(List<Lesson> lessons) {
        this.lessons = lessons;
    }
}
