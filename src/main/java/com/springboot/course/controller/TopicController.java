package com.springboot.course.controller;

import com.springboot.course.dto.TopicDto;
import com.springboot.course.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TopicController {

    @Autowired
    private TopicService topicService;

    @RequestMapping(method = RequestMethod.GET, value ="/topics")
    public List<TopicDto> getAllTopics() {
        return   topicService.getAllTopics();
    }

    @RequestMapping(method = RequestMethod.GET,value= "/topics/{id}")
    public TopicDto getTopicById(@PathVariable String id)
    {
        return topicService.getTopicById(id);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/topics")
    public TopicDto addTopic(@RequestBody TopicDto topicDto)
    {
        return topicService.addTopic(topicDto);
    }

    @RequestMapping(method = RequestMethod.PUT,value= "/topics")
    public  TopicDto updateTopic( @RequestBody TopicDto topicDto)
    {
        return topicService.updateTopic(topicDto);
    }

    @RequestMapping(method = RequestMethod.DELETE,value= "/topics/{id}")
    public  void deleteTopic(@PathVariable String id)
    {
        topicService.deleteTopic(id);
    }
}

