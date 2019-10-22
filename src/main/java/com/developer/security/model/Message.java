package com.developer.security.model;

import java.time.LocalDateTime;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data@NoArgsConstructor
public class Message {
	
	private int id ;
	private String text;
	private LocalDateTime created;
	private String to_user;
	private String from_user;
	@JsonCreator
	public Message(@JsonProperty("id") int id, 
			@JsonProperty("text") String text, 
			@JsonProperty("created") LocalDateTime created, 
			@JsonProperty("to_user") String to_user, 
			@JsonProperty("from_user") String from_user) {

		this.id = id;
		this.text = text;
		this.created = created;
		this.to_user = to_user;
		this.from_user = from_user;
	}
	public Message(String text, String to_user) {
	
		this.text = text;
		this.to_user = to_user;

	}
	
	
	

}
