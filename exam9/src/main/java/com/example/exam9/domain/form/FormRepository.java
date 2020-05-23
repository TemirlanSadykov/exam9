package com.example.exam9.domain.form;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FormRepository extends JpaRepository<Form, Integer> {
    Optional<Form> findByName(String name);
}
