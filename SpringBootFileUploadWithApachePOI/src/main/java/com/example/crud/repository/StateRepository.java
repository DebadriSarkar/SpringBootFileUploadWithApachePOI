package com.example.crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.crud.entity.StateEntity;

@Repository
public interface StateRepository extends JpaRepository<StateEntity, Integer>{

}
