package com.philipap.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.philipap.entity.Topic;

@Service
public interface TopicService {
	
    public abstract List<Topic> getAllTopics();
	
	public abstract Topic getTopicById(Integer topicId);
	
	public abstract boolean addTopic(Topic topic);
	
	public abstract void updateTopic(Topic topic);
	
	public abstract void  deleteTopic(Integer topicId);	

}
