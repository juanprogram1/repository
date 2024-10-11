package com.example.api_rest.Person;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PersonService {

    private final PersonRepository personRepository;

    // Create person
    public Person createPerson(Person person) {
        return personRepository.save(person);
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
            return null;
        }
    }

    // Get person by id
    public Person getPersonById(int id) {
        Optional<Person> optionalPerson = personRepository.findById(id);

        if (optionalPerson.isPresent()) {
            return optionalPerson.get();

        }
        return null;
    }

    // Get all persons
    public List<Person> getAllPersons() {
        return personRepository.findAll();
    }

    // Get all persons by first name
    public List<Person> getAllPersonsByFirstName(String firstName) {
        return personRepository.findByFirstName(firstName);
    }

    // Delete person by id
    public String deletePersonById(int id) {
        Optional<Person> optionalPerson = personRepository.findById(id);

        if (optionalPerson.isPresent()) {
            Person person = optionalPerson.get();
            personRepository.delete(person);
            return "Person deleted successfully";
        } else {
            return null;
        }

    }
}
