package com.example.db;

import org.springframework.data.repository.CrudRepository;

public interface PersonRepository extends CrudRepository<PersonBO, Integer>{};
