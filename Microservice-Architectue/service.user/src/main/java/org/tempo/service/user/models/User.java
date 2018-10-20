package org.tempo.service.user.models;

import java.time.LocalDate;

import org.springframework.stereotype.Component;

@Component
public class User {

	private String id;
	private String name;
	private LocalDate dob;

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

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

}
