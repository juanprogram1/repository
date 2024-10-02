package com.example.api_rest.Person;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Person {

    @Id
    @jakarta.persistence.GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private int id;
    // Add validation for firstName
    @Column(nullable = false, length = 100)
    private String firstName;

    // Add validation for lastName
    @Column(nullable = false, length = 100)
    private String lastName;

    // Add validation for email
    @Column(nullable = false, length = 255)
    private String email;

    // Add validation for phone
    @Column(nullable = false)
    private int phone;

    // Add validation for age
    @Column(nullable = false)
    private int age;

    // Date creation
    @CreationTimestamp
    private java.sql.Timestamp createdAt;

    // Date update
    @UpdateTimestamp
    private java.sql.Timestamp updatedAt;
}
