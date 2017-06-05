package com.pll.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pll.model.Talk;
import com.pll.model.Topic;
import com.pll.repository.TalkRepository;
import com.pll.repository.TopicRepository;

@RestController
@RequestMapping("/talks")
public class AppControler {
	
/*	@Autowired
	public TalkControler(TalkRepository talkRepository) {
		this.talkRepository = talkRepository;

	}
	
	private final TalkRepository talkRepository;
*/
	@Autowired
	private TalkRepository talkRepository;
	
	@Autowired
	private TopicRepository topicRepository;
	
	@RequestMapping(method = RequestMethod.POST)
	public void addTalks(@RequestBody Talk talk) {
		talkRepository.save(talk);
		
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public List<Talk> getTalks() {
		return (List<Talk>) talkRepository.findAll();
		
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Talk getTalk(@PathVariable("id") int id) {
		Talk talk = talkRepository.findById(id);
		
		return talk;
		//return new ResponseEntity<Talk>(talk, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/TopicJPA/{id}", method = RequestMethod.GET)
	public Topic getTopic(@PathVariable("id") int id) {
		Topic topic = new Topic();
		List<Talk> talks  = talkRepository.findAll();
		
		for(Talk t : talks) {
			if (t.getId() == id) {
				topic.setTopic(t.getTopic());
			}
		}
		
		return topic;
		//return new ResponseEntity<Talk>(talk, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/TopicJDBC/", method = RequestMethod.GET)
	public List<Topic> getTopicJdbc() {
		List<Topic> talks  = topicRepository.findAll();
		
	
		return talks;
		//return new ResponseEntity<Talk>(talk, HttpStatus.OK);
	}


	
	


}
