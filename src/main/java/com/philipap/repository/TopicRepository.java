package com.philipap.repository;

import java.util.List;

import com.philipap.entity.Topic;

public interface TopicRepository {
	public abstract List<Topic> getAllTopics();
	
	public abstract Topic getTopicById(Integer topicId);
	
	public abstract void addTopic(Topic topic);
	
	public abstract void updateTopic(Topic topic);
	
	public abstract void  deleteTopic(Integer topicId);
	
	public abstract boolean TopicExists(String title, String category);

}
