package com.pll.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.pll.model.Talk;
import com.pll.model.Topic;

public interface TalkRepository extends JpaRepository<Talk, Integer>{
	Talk findById(int id);

}
