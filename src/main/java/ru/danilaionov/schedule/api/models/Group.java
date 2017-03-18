package ru.danilaionov.schedule.api.models;

/**
 * Created by Danila Ionov on 11/4/2016.
 */
public class Group {

    private int id;
    private String name;

    public Group(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
