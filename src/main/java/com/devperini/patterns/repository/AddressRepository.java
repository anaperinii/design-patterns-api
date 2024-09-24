package com.devperini.patterns.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.devperini.patterns.model.Address;

@Repository
public interface AddressRepository extends CrudRepository<Address, String> {
    
}
