package org.tempo.service.product.controllers;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.tempo.service.product.models.Product;

@RestController
public class TempoProductMainController {

	@Autowired
	private Product user;

	@RequestMapping(value = "product/{id}")
	public Product findUser(@PathVariable String id) {
		user.setId(id);
		user.setName("Ajay");
		user.setManufaturedDate(LocalDate.now());
		return user;
	}

}
