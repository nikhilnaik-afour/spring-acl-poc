package com.aclpoc.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Table;

@Entity
@Table(name = "clients")
public class ClientJpaEntity {

	@jakarta.persistence.Id
	@GeneratedValue
	long id;

	@Column(name = "name")
	private String name;

	@Column(name = "location")
	private String location;

	@Column(name = "initializationDate")
	private LocalDate initializationDate;

	public ClientJpaEntity() {
		super();
	}

	public ClientJpaEntity(String name, String location, LocalDate initializationDate) {
		super();
		this.name = name;
		this.location = location;
		this.initializationDate = initializationDate;
	}

	public ClientJpaEntity(long id, String name, String location, LocalDate initializationDate) {
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
