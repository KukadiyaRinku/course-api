package com.springboot.course.controller;

import com.springboot.course.dto.CourseDto;
import com.springboot.course.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CourseController {
    @Autowired
    private CourseService courseService;

    @RequestMapping(method = RequestMethod.GET, value = "/courses")
    public List<CourseDto> getAllCourses() {
        return courseService.getAllCourses();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/courses/topics/{topicId}")
    public List<CourseDto> getAllCoursesByTopicId(@PathVariable String topicId) {
        return courseService.getAllCoursesByTopicId(topicId);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/course/{id}")
    public CourseDto getCourseById(@PathVariable String id) {
        return courseService.getCourseById(id);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/courses")
    public CourseDto addCourse(@RequestBody CourseDto courseDto) {
        return courseService.addCourse(courseDto);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/courses")
    public CourseDto updateCourse(@RequestBody CourseDto courseDto) {
        return courseService.updateCourse(courseDto);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/courses/{id}")
    public void deleteCourse(@PathVariable String id) {
        courseService.deleteCourse(id);
    }

}
