package com.springboot.course.service;

import com.springboot.course.dto.CourseDto;
import com.springboot.course.entity.Course;
import com.springboot.course.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CourseService {
    @Autowired
    private CourseRepository courseRepository;

    public List<CourseDto> getAllCourses() {

        List<Course> courses = new ArrayList<>();
        courseRepository.findAll().forEach(courses::add);

        return courses.stream().map(this::toDto).collect(Collectors.toList());
    }

    public CourseDto getCourseById(String id) {

        return toDto(courseRepository.findById(id).orElse(new Course()));
    }

    public CourseDto addCourse(CourseDto courseDto) {
        courseRepository.save(toEntity(courseDto));
        return courseDto;
    }

    public CourseDto updateCourse(CourseDto courseDto) {
        courseRepository.save(toEntity(courseDto));
        return courseDto;
    }

    public void deleteCourse(String id) {

        courseRepository.deleteById(id);
    }

    public List<CourseDto> getAllCoursesByTopicId(String topicId) {

        List<Course> courses = new ArrayList<>();
        courseRepository.findAllByTopicId(topicId).forEach(courses::add);

        return courses.stream().map(this::toDto).collect(Collectors.toList());
    }

    public Course toEntity(CourseDto dto)
    {
        Course entity = new Course();
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        entity.setDescription(dto.getDescription());
        return  entity;
    }

    public CourseDto toDto(Course entity)
    {
        CourseDto dto = new CourseDto();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setDescription(entity.getDescription());
        return  dto;
    }
}
