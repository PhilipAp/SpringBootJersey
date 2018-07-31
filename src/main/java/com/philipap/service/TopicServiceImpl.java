package com.philipap.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.philipap.entity.Topic;
import com.philipap.repository.TopicRepository;

@Service
public class TopicServiceImpl implements TopicService{
	
	@Autowired
	private TopicRepository topicRepository;

	@Override
	public List<Topic> getAllTopics() {
		return topicRepository.getAllTopics();
	}

	@Override
	public Topic getTopicById(Integer topicId) {
		return topicRepository.getTopicById(topicId);
	}

	@Override
	public synchronized boolean addTopic(Topic topic) {
		if(topicRepository.TopicExists(topic.getTitle(), topic.getCategory())) {
			return false;	
		}
		else {
			topicRepository.addTopic(topic);
			return true;
		}
	}

	@Override
	public void updateTopic(Topic topic) {
		topicRepository.updateTopic(topic);
	}

	@Override
	public void deleteTopic(Integer topicId) {
		topicRepository.deleteTopic(topicId);
	}

}
