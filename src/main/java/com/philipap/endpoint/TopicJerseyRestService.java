package com.philipap.endpoint;



import java.net.URI;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.philipap.entity.Topic;
import com.philipap.service.TopicService;

@Component
@Path("/topics")
public class TopicJerseyRestService {
	private static final Logger logger = LoggerFactory.getLogger(TopicJerseyRestService.class);
	
	@Autowired
	private TopicService topicService;
	
	@POST
	@Path("/create")
	@Consumes
	@CrossOrigin
	public Response createTopic(Topic topic) {
		boolean isAdded = topicService.addTopic(topic);
		if(!isAdded) {
			logger.info("Topic Already Exists");
			return Response.status(Status.CONFLICT).build();
		}
		return Response.created(URI.create("/topics/topic"+topic.getTopicId())).build();		
	}
	
	@PUT
	@Path("/topic/update")
	@Produces
	@Consumes
	@CrossOrigin
	public Response updateTopic(Topic topic) {
		topicService.updateTopic(topic);
		return Response.ok(topic).build();		
	}
	
	@GET
	@Path("/topicId/{topicId}")
	@Produces	
	@CrossOrigin
	public Response getTopicById(@PathParam("topicId") Integer topicId) {
		Topic topic = topicService.getTopicById(topicId);
		return Response.ok(topic).build();		
	}	
	

	@GET	
	@Produces	
	@CrossOrigin
	public Response getAllTopics() {
		List<Topic> list = topicService.getAllTopics();
		return Response.ok(list).build();		
	}
	
	@DELETE
	@Path("/topicId/{topicId}")
	@Consumes	
	@CrossOrigin
	public Response deleteTopic(@PathParam("topicId") Integer topicId) {
		topicService.deleteTopic(topicId);
		return Response.noContent().build();		
	}	
	
	
	
	

}
