package com.example.exam9.domain.customer;

import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

@Service
@AllArgsConstructor
public class CustomerService {

    private final CustomerRepository repository;
    private final PasswordEncoder encoder;

    public CustomerResponseDTO register(CustomerRegisterForm form) throws IOException {
        if (repository.existsByEmail(form.getEmail())) {
            throw new CustomerAlreadyRegisteredException();
        }

        var user = Customer.builder()
                .email(form.getEmail())
                .name(form.getName())
                .login(form.getLogin())
                .password(encoder.encode(form.getPassword()))
                .build();

        repository.save(user);

        return CustomerResponseDTO.from(user);
    }

    public CustomerResponseDTO getByEmail(String email) {
        var user = repository.findByEmail(email)
                .orElseThrow(CustomerNotFoundException::new);

        return CustomerResponseDTO.from(user);
    }
}
