package com.devperini.patterns.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.devperini.patterns.model.Client;

@Repository
public interface ClientRepository extends CrudRepository<Client, Long> {
    
}
