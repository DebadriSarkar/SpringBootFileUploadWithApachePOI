package com.example.crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.crud.entity.CountryEntity;

@Repository
public interface CountryRepository extends JpaRepository<CountryEntity, Integer>{

	
}
