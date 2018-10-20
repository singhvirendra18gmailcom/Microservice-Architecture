package org.tempo.service.user.controllers;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.tempo.service.user.models.User;

@RestController
public class TempoUserMainController {

	@Autowired
	private User user;

	@RequestMapping(value = "user/{id}")
	public User findUser(@PathVariable String id) {
		user.setId(id);
		user.setName("Ajay");
		user.setDob(LocalDate.now());
		return user;
	}

}
