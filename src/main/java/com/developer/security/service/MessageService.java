package com.developer.security.service;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.developer.security.model.Message;
import com.developer.security.model.UiMessage;
import com.developer.security.utils.MessageRowMapper;

@Service
public class MessageService {
	@Autowired
	NamedParameterJdbcTemplate jdbc;
	
	public Collection<Message> fetchAll(){
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String username = ((UserDetails)principal).getUsername();
		String sql = "select * from message m where m.from_user = :from_user ";
		List<Message> rs = jdbc.query(sql,new MapSqlParameterSource("from_user", username) ,new MessageRowMapper());
		return rs;
	}
	
	public void save(UiMessage msg) {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String email = ((UserDetails)principal).getUsername();
		
		String sql = "insert into message(text ,created ,to_user,	from_user)\n" + 
				"values(:text, :created, :to_user,:from_user)";
		 int i = jdbc.update(sql, new MapSqlParameterSource().addValue("text", msg.getText())
				.addValue("created", LocalDateTime.now())
				.addValue("to_user", msg.getTo_user())
				.addValue("from_user", email));
		
	}
	

}
