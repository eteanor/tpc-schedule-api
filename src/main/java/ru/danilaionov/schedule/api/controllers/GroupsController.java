package ru.danilaionov.schedule.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.danilaionov.schedule.api.models.Group;

import java.util.List;

/**
 * Created by Danila Ionov on 11/4/2016.
 */
@RestController
@RequestMapping("/groups")
public class GroupsController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @RequestMapping
    public List<Group> get() {
        return jdbcTemplate.query("select group_id, group_name from dean_groups where group_use='T'",
                (rs, rowNum) -> new Group(rs.getInt("group_id"), rs.getString("group_name")));
    }
}
