package com.philipap.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.philipap.entity.Topic;

@Transactional
@Repository
public class TopicRepositoryImpl implements TopicRepository{
	
	@PersistenceContext
	private EntityManager entityManager;

	@SuppressWarnings("unchecked")
	@Override
	public List<Topic> getAllTopics() {
		String hql = "From Topic as t Order By t.topicId";
		return (List<Topic>) entityManager.createQuery(hql).getResultList();
	}

	@Override
	public Topic getTopicById(Integer topicId) {
		return entityManager.find(Topic.class, topicId);
	}

	@Override
	public void addTopic(Topic topic) {
		entityManager.persist(topic);		
	}

	@Override
	public void updateTopic(Topic topic) {
		Topic dbtopic = getTopicById(topic.getTopicId());
		dbtopic.setTitle(topic.getTitle());
		dbtopic.setCategory(topic.getCategory());
		entityManager.flush();
	}

	@Override
	public void deleteTopic(Integer topicId) {
		entityManager.remove(getTopicById(topicId));
	}

	@Override
	public boolean TopicExists(String title, String category) {
		String hql = "From Topic as t where t.title = ? and t.category = ? ";
		Integer count = entityManager.createQuery(hql).setParameter(1, title)
				                                      .setParameter(2, category)
				                                      .getResultList()
				                                      .size();
		return count > 0 ? true : false;
	}

}
