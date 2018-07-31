package com.philipap.jerseyconfig;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

import com.philipap.endpoint.TopicJerseyRestService;

@Component
public class JerseyConfig extends ResourceConfig{
	
	public JerseyConfig() {
		register(TopicJerseyRestService.class);
	}

}
