package org.tempo.service.product.models;

import java.time.LocalDate;

import org.springframework.stereotype.Component;

@Component
public class Product {

	private String id;
	private String name;
	private LocalDate manufaturedDate;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getManufaturedDate() {
		return manufaturedDate;
	}

	public void setManufaturedDate(LocalDate manufaturedDate) {
		this.manufaturedDate = manufaturedDate;
	}

	

}
