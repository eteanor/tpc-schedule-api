package ru.danilaionov.schedule.api.models;

import java.util.List;

/**
 * Created by danilaionov on 15/03/2017.
 */
public class Schedule {

    private List<Day> red;
    private List<Day> green;

    public List<Day> getRed() {
        return red;
    }

    public void setRed(List<Day> red) {
        this.red = red;
    }

    public List<Day> getGreen() {
        return green;
    }

    public void setGreen(List<Day> green) {
        this.green = green;
    }
}
