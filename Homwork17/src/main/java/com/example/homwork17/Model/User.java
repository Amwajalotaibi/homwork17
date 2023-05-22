package com.example.homwork17.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@Entity
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "name can't be null")
    @Column(columnDefinition = "varchar(5) not null")
    private String name;

    @NotEmpty(message = "user name can't be null ")
    @Column(columnDefinition = "varchar(4) unique not null")
    private String username;

    @NotEmpty(message = " password can't be null ")
    @Column(columnDefinition = "varchar(10) not null")
    private String password;

    @Email
    @NotEmpty(message = "email can't be null")
    @Column(columnDefinition = "varchar(10) unique not null check( email='Valid' or email = 'not Valid' ) ")
    private String email;

    @NotEmpty(message = " role can't be null")
    @Column(columnDefinition =" varchar(10) not null check( role='user' or role = 'admin' )")
    private String role;

    @NotEmpty(message =" age can't be null")
    @Column(columnDefinition =" Int not null ")
    private Integer age;

}
