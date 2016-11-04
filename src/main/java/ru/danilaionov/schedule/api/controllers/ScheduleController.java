package ru.danilaionov.schedule.api.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.danilaionov.schedule.api.models.Day;
import ru.danilaionov.schedule.api.models.Lesson;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Danila Ionov on 11/4/2016.
 */
@RestController
@RequestMapping("/schedule")
public class ScheduleController {

    @RequestMapping
    public List<Day> get(@RequestParam("groupId") int groupId,
                         @RequestParam("from") String from, @RequestParam("to") String to) {
        List<Lesson> lessons = new ArrayList<>();
        lessons.add(new Lesson(1, "biology"));
        lessons.add(new Lesson(2, Integer.toString(groupId)));
        lessons.add(new Lesson(3, from));
        lessons.add(new Lesson(4, to));

        Day day = new Day(new Date(), lessons);

        List<Day> days = new ArrayList<>();

        days.add(day);

        return days;
    }

}
