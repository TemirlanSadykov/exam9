package com.example.exam9.domain.customer;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    public boolean existsByEmail(String email);

    public Optional<Customer> findByName(String name);

    public Optional<Customer> findByEmail(String email);
}
