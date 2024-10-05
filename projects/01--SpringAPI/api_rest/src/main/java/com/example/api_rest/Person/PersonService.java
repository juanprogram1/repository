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
    public String createPerson(Person person) {
        personRepository.save(person);
        return "Welcome " + person.getFirstName() + " " + person.getLastName();
    }

    // Update person
    public String updatePerson(int id, PersonUpdateDTO updateDTO) {
        Optional<Person> optionalPerson = personRepository.findById(id);

        if (optionalPerson.isPresent()) {
            Person personToUpdate = optionalPerson.get();

            personToUpdate.setFirstName(updateDTO.getFirstName());
            personToUpdate.setLastName(updateDTO.getLastName());
            personToUpdate.setEmail(updateDTO.getEmail());
            personToUpdate.setPhone(updateDTO.getPhone());
            personToUpdate.setAge(updateDTO.getAge());

            personToUpdate.setUpdatedAt(new Timestamp(System.currentTimeMillis()));

            personRepository.save(personToUpdate);

            return "Person updated successfully";

        } else {
            return "Person not found";
        }
    }

    // Get person by id
    public String getPersonById(int id) {
        Optional<Person> optionalPerson = personRepository.findById(id);

        if (optionalPerson.isPresent()) {
            Person person = optionalPerson.get();
            return "Person found: " + person.toString();
        } else {
            return "Person not found";
        }
    }

    // Delete person by id
    public String deletePersonById(int id) {
        Optional<Person> optionalPerson = personRepository.findById(id);

        if (optionalPerson.isPresent()) {
            Person person = optionalPerson.get();
            personRepository.delete(person);
            return "Person deleted successfully";
        } else {
            return "Person not found";
        }

    }

}
