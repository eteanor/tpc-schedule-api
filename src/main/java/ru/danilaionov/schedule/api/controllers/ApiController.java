package ru.danilaionov.schedule.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.danilaionov.schedule.api.models.*;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by danilaionov on 15/03/2017.
 */
@RestController
@RequestMapping("/api")
public class ApiController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @RequestMapping("/group")
    public List<Group> getGroups() {
        return jdbcTemplate.query("select group_id, group_name from dean_groups where group_use='T' order by group_name asc",
                (rs, rowNum) -> new Group(rs.getInt("group_id"), rs.getString("group_name")));
    }

    @RequestMapping("/group/{id}/schedule")
    public Schedule getSchedule(@PathVariable("id") int groupId) throws ParseException {

        String query = "select pairnum as pairNum, dean_lesson.name as name, ep_timetable.days as dayNumber\n" +
                "from dean_lesson, ep_timetable, dean_groups\n" +
                "where groups=?\n" +
                "and groups=dean_groups.group_id\n" +
                "and discipline=dean_lesson.id\n" +
                "order by days asc, pairnum asc";

        Object[] params = new Object[] {groupId};

        List<DBLesson> dbLessonList = jdbcTemplate.query(query, params, (rs, rowNum) -> new DBLesson(rs.getInt("pairNum"), rs.getString("name"), rs.getInt("dayNumber")));

        Schedule schedule = new Schedule();

        List<Day> redWeek = new ArrayList<>();
        List<Day> greenWeek = new ArrayList<>();

        int curDay = 0;
        List<Lesson> lessons = null;
        Day day;

        for (DBLesson dbLesson : dbLessonList) {
            if (curDay == dbLesson.getDayNumber()) {
                lessons.add(createLesson(dbLesson));

            } else {
                curDay = dbLesson.getDayNumber();

                day = new Day();
                day.setNumber(dbLesson.getDayNumber());

                lessons = new ArrayList<>();

                lessons.add(createLesson(dbLesson));
                day.setLessons(lessons);

                if (dbLesson.getDayNumber() < 8 && dbLesson.getDayNumber() > 0) {
                    redWeek.add(day);
                }
                else {
                    greenWeek.add(day);
                }
            }
        }

        schedule.setRed(redWeek);
        schedule.setGreen(greenWeek);

        return schedule;
    }

    private Lesson createLesson(DBLesson dbLesson) {
        Lesson lesson = new Lesson();
        lesson.setNumber(dbLesson.getNumber());
        lesson.setName(dbLesson.getName().trim());
        return lesson;
    }
}
