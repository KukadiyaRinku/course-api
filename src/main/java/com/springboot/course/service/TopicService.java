package com.springboot.course.service;

import com.springboot.course.common.ErrorMessage;
import com.springboot.course.dto.TopicDto;
import com.springboot.course.entity.Topic;
import com.springboot.course.exception.NoSuchItemfoundException;
import com.springboot.course.repository.TopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TopicService {

    @Autowired
    private TopicRepository topicRepository;

    public List<TopicDto> getAllTopics() {
        List<Topic> topics = new ArrayList<>();
        topicRepository.findAll().forEach(topics::add);

        return topics
                .stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    public TopicDto getTopicById(String id) {

        Optional<Topic> topic = topicRepository.findById(id);
        if (topic.isEmpty())
            throw new NoSuchItemfoundException("", new ErrorMessage("Topic with Id:" + id + " not exists." ,404,""));

        return toDto(topic.get());
    }

    public TopicDto addTopic(TopicDto topicDto) {
        topicRepository.save(toEntity(topicDto));
        return topicDto;
    }

    public TopicDto updateTopic(TopicDto topicDto) {
        topicRepository.save(toEntity(topicDto));
        return topicDto;
    }

    public void deleteTopic(String id) {
        topicRepository.deleteById(id);
    }

    public Topic toEntity(TopicDto dto) {
        Topic entity = new Topic();
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        entity.setDescription(dto.getDescription());
        return entity;
    }

    public TopicDto toDto(Topic entity) {
        TopicDto dto = new TopicDto();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setDescription(entity.getDescription());
        return dto;
    }

}
