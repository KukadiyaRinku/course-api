package com.springboot.course.repository;

import com.springboot.course.entity.Topic;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TopicRepository extends CrudRepository <Topic ,String> {
}
