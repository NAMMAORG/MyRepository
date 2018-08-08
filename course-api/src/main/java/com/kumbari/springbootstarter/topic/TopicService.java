package com.kumbari.springbootstarter.topic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class TopicService 
{
	private List<Topic>	topics = new ArrayList<>( Arrays.asList( new Topic("spring", "Spring Framework", "Spring framework Description"),
								 new Topic("java", "Core Java", "Core Java Description"),
								 new Topic("rest", "REST Webservice", "REST Webservices Description")
								)); 
	
	public List<Topic> getAllTopics() {
		return topics;
	}
	
	public Topic getTopic(String id){
		return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
	}

	public void addTopic(Topic topic) {
		
		topics.add(topic);
	}

	public void removeTopic(String id) {
		topics.removeIf(t -> t.getId().equals(id));
	}

	public void updateTopic(Topic topic, String id) {
		for (int i = 0; i < topics.size(); i++) {
			Topic t= topics.get(i);
			if(t.getId().equals(id)) {
				topics.set(i, topic);
				return;	
			}
				
		}
	}
}
