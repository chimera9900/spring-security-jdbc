package com.developer.security.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.developer.security.model.Message;
import com.developer.security.model.UiMessage;
import com.developer.security.service.MessageService;

@PreAuthorize("hasRole('ROLE_ADMIN')")
@Controller
@RequestMapping
public class MessageController {
	@Autowired
	MessageService msgService;
	
	@PreAuthorize("hasRole('ROLE_USER')")
	@RequestMapping
	public @ResponseBody Collection<Message> list() {
		return msgService.fetchAll();
		
	}
	
//	@RequestMapping(method = RequestMethod.POST)
//	public void save(@RequestBody UiMessage msg) {
//		msgService.save(msg);
//	}
	
	@Autowired
	NamedParameterJdbcTemplate jdbc;
	
	
	@PreAuthorize("hasRole('ROLE_USER')")
	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public String createMsg(Model model) {
		UiMessage uiMsg = new UiMessage();
		
		model.addAttribute("msg", uiMsg);
		
		return "createMsg";
	}

	
	@RequestMapping(value = "/create", method = RequestMethod.POST, 
			consumes = {MediaType.APPLICATION_FORM_URLENCODED_VALUE })
	public String createMsg( UiMessage msg) {
		
		msgService.save(msg);
		
		return "redirect:/";
	}
	

}
