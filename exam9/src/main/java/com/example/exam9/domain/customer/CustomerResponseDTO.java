package com.example.exam9.domain.customer;

import lombok.*;

@Data
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Builder(access = AccessLevel.PACKAGE)
public class CustomerResponseDTO {
    private int id;
    private String login;
    private String email;
    private String name;

    static CustomerResponseDTO from(Customer user) {
        return builder()
                .id(user.getId())
                .login(user.getLogin())
                .email(user.getEmail())
                .name(user.getName())
                .build();
    }
}
