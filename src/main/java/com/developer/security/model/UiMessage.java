package com.developer.security.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UiMessage {
	
	private String text;
	private String to_user;
	@JsonCreator
	public UiMessage(
			@JsonProperty("text") String text, 
			@JsonProperty("to_user") String to_user
			) {

		this.text = text;
		this.to_user = to_user;
	}

}
