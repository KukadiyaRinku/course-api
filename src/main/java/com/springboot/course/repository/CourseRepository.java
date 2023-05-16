package com.springboot.course.repository;

import com.springboot.course.entity.Course;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CourseRepository extends CrudRepository <Course , String> {
    List<Course> findAllByTopicId(String topicId);
}
