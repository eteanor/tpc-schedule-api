package ru.danilaionov.schedule.api.models;

import java.util.Date;
import java.util.List;

/**
 * Created by Danila Ionov on 11/4/2016.
 */
public class Day {

    private Date date;
    private List<Lesson> lessons;

    public Day() {
    }

    public Day(Date date, List<Lesson> lessons) {
        this.date = date;
        this.lessons = lessons;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public List<Lesson> getLessons() {
        return lessons;
    }

    public void setLessons(List<Lesson> lessons) {
        this.lessons = lessons;
    }
}
