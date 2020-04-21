package io.javabrains.springbootstarter.topic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class TopicService {
	
	@Autowired
	private TopicRepository topicRepository;
	
	public List<Topic> getAllTopics() { 
		List<Topic> topics = new ArrayList<>();
		topicRepository.findAll().forEach(topics::add);
		return topics;
	}
	
	public Topic getTopic(String id) { 
		Optional<Topic> topics = topicRepository.findById(id);
		return topics.get();
	}
	
	public void addTopic(Topic topic) { 
		topicRepository.save(topic); 
	}
	
	public void updateTopic(@RequestBody Topic topic, @PathVariable String id) {
		topicRepository.save(topic);
	}
	
	public void deleteTopic(String id) { 
		topicRepository.deleteById(id);
	}

}
