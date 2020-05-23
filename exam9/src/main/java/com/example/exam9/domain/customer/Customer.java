package com.example.exam9.domain.customer;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Set;

@Data
@Table(name = "customer")
@Entity
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PACKAGE)
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Email
    @NotBlank
    @Column(length = 128)
    private String email;

    @NotBlank
    @Pattern(regexp = "^[^\\d\\s]+$")
    @Column(length = 128)
    private String name;

    @NotBlank
    @Size(min = 8)
    @Column(length = 128)
    private String password;

    @NotBlank
    @Size(min = 4, message = "LOGIN")
    @Column(length = 128)
    private String login;

    @Column
    @Builder.Default
    private boolean enabled = true;

    @NotBlank
    @Size(min = 1, max = 128)
    @Column(length = 128)
    @Builder.Default
    private String role = "USER";

}
