package com.example.crud.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "states_new")
public class StateEntity {

	
	@Id
	@Column(name = "stateId")
	private Integer stateId;
	
	
	@Column(name = "name")
	private String name;
	
	
	@Column(name = "countryId")
	private Integer countryId;


	public Integer getStateId() {
		return stateId;
	}


	public void setStateId(Integer stateId) {
		this.stateId = stateId;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public Integer getCountryId() {
		return countryId;
	}


	public void setCountryId(Integer countryId) {
		this.countryId = countryId;
	}
	
	
}
