package com.pll.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class Talk {

	@Id
	@SequenceGenerator(name="talk_id_seq", sequenceName="talk_id_seq", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="talk_id_seq")
	private int id;
	
	private String topic;

	public int getId() {
		return id;
	}

	public String getTopic() {
		return topic;
	}

}
