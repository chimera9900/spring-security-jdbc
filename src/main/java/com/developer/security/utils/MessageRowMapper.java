package com.developer.security.utils;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.Calendar;

import org.springframework.jdbc.core.RowMapper;

import com.developer.security.model.Message;

public class MessageRowMapper implements RowMapper<Message> {

	@Override
	public Message mapRow(ResultSet rs, int rowNum) throws SQLException {
		Message message = new Message();
		message.setId(rs.getInt("id"));
		message.setText(rs.getString("text"));
		message.setTo_user(rs.getString("to_user"));
		message.setFrom_user(rs.getString("from_user"));
		message.setCreated(rs.getObject("created", LocalDateTime.class));
		return message;
	}

}
