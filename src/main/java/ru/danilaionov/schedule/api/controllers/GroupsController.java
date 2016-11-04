package ru.danilaionov.schedule.api.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.danilaionov.schedule.api.models.Group;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Danila Ionov on 11/4/2016.
 */
@RestController
@RequestMapping("/groups")
public class GroupsController {

    @RequestMapping
    public List<Group> get() {
        List<Group> groups = new ArrayList<>();
        groups.add(new Group(1, "v11"));
        groups.add(new Group(2, "v12"));
        groups.add(new Group(3, "v13"));
        groups.add(new Group(4, "v21"));
        groups.add(new Group(5, "v22"));
        groups.add(new Group(6, "v31"));
        groups.add(new Group(7, "v32"));
        groups.add(new Group(8, "v41"));

        return groups;
    }

}
