package com.example.api_rest.Person;

import java.sql.Timestamp;
import java.util.Optional;

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

    public Person updatePerson(int id, Person person) {
        Optional<Person> optionalPerson = personRepository.findById(id);

        if (optionalPerson.isPresent()) {
            Person personNow = optionalPerson.get();

            personNow.setFirstName(person.getFirstName());
            personNow.setLastName(person.getLastName());
            personNow.setEmail(person.getEmail());
            personNow.setPhone(person.getPhone());
            personNow.setAge(person.getAge());

            // update the person
            personNow.setUpdatedAt(new Timestamp(System.currentTimeMillis()));

            // push the changes to the database
            return personRepository.save(personNow);

        }

        return null;
    }

    // Get person by id
    public Person getPersonById(int id) {
        return personRepository.findById(id).orElse(null);
    }

    // Delete person by id
    public void deletePersonById(int id) {
        personRepository.deleteById(id);
    }

}
