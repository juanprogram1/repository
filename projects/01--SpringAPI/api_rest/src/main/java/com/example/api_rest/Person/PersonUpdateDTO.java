package com.example.api_rest.Person;

import lombok.Data;

@Data
public class PersonUpdateDTO {

    private String firstName;
    private String lastName;
    private String email;
    private Long phone;
    private Integer age;
}
