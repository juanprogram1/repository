package com.example.api_rest.Person;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
    private Long phone;

    // Add validation for age
    @Column(nullable = false)
    private int age;

    // Date creation automatically to insert
    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private Timestamp createdAt;

    // Date update
    @UpdateTimestamp
    @Column(name = "updated_at")
    private Timestamp updatedAt;
}
