package com.example.crud.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "countries_new")
public class CountryEntity {

	
	@Id
	@Column(name = "countryId")
	private Integer countryId;
	
	
	@Column(name = "sortname")
	private String sortname;
	
	
	@Column(name = "name")
	private String name;
	
	
	@Column(name = "phonecode")
	private Integer phonecode;


	public Integer getCountryId() {
		return countryId;
	}


	public void setCountryId(Integer countryId) {
		this.countryId = countryId;
	}


	public String getSortname() {
		return sortname;
	}


	public void setSortname(String sortname) {
		this.sortname = sortname;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public Integer getPhonecode() {
		return phonecode;
	}


	public void setPhonecode(Integer phonecode) {
		this.phonecode = phonecode;
	}
	
	
	
}
