package com.pll.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.pll.model.Topic;

@Repository
public class TopicRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Transactional(readOnly=true)
    public List<Topic> findAll() {
        return (jdbcTemplate.query("select topic from Talk", new TopicMapper()));
    }
    
	private static final class TopicMapper implements RowMapper<Topic> {

		@Override
		public Topic mapRow(ResultSet resultSet, int rowNum) throws SQLException {
			Topic topic = new Topic();
			topic.setTopic(resultSet.getString("TOPIC"));
			return topic;
		}
		
	}

}
