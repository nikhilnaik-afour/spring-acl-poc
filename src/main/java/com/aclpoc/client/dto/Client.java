package com.aclpoc.client.dto;

import java.time.LocalDate;

public class Client {

	private long id;
	private String name;
	private String location;
	private LocalDate initializationDate;

	public Client() {
		super();
	}

	public Client(String name, String location, LocalDate initializationDate) {
		super();
		this.name = name;
		this.location = location;
		this.initializationDate = initializationDate;
	}

	public Client(long id, String name, String location, LocalDate initializationDate) {
		super();
		this.id = id;
		this.name = name;
		this.location = location;
		this.initializationDate = initializationDate;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public LocalDate getInitializationDate() {
		return initializationDate;
	}

	public void setInitializationDate(LocalDate initializationDate) {
		this.initializationDate = initializationDate;
	}

}
