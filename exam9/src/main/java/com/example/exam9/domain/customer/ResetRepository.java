package com.example.exam9.domain.customer;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ResetRepository extends JpaRepository<PasswordResetToken, Integer> {

    public boolean existsByToken(String token);

    Optional<PasswordResetToken> deleteAllByCustomer(String customer);

    public Optional<PasswordResetToken> findByToken(String token);
}
