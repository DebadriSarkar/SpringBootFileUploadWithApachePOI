package com.example.crud.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "cities_new")
public class CityEntity {

	
	@Id
	@Column(name = "cityId")
	private Integer cityId;
	
	
	@Column(name = "name")
	private String name;
	
	
	@Column(name = "stateId")
	private Integer stateId;


	public Integer getCityId() {
		return cityId;
	}


	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public Integer getStateId() {
		return stateId;
	}


	public void setStateId(Integer stateId) {
		this.stateId = stateId;
	}
	
	
}
