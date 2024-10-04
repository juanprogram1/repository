package com.example.api_rest.Person;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PersonService {

    private final PersonRepository personRepository;

    // Create person
    public void createPerson(Person person) {
        personRepository.save(person);
    }

    // filter by email
    public Person findPersonByEmail(String email) {
        return personRepository.findByEmail(email);
    }

    // filter by firstName
    public List<Person> findPersonByFirstName(String firstName) {
        return personRepository.findByFirstName(firstName);
    }
}
