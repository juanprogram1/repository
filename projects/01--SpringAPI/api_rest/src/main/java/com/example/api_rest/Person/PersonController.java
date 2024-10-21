package com.example.api_rest.Person;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/person")
@RequiredArgsConstructor
public class PersonController {

    private final PersonService personService;

    // Create person endpoint}
    // @RequestMapping(method = RequestMethod.POST, value = "/create")
    @PostMapping("/create")
    public ResponseEntity<Person> createPerson(@RequestBody Person person) {
        personService.createPerson(person);

        // URI to the newly created person
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{firstName}")
                .buildAndExpand(person.getFirstName()).toUri();

        return ResponseEntity.created(location).build();
    }

    // Update person endpoint
    // @RequestMapping(method = RequestMethod.PUT, value = "/update/{id}")
    @PutMapping("/update/{id}")
    public ResponseEntity<String> updatePerson(@PathVariable int id, @RequestBody PersonUpdateDTO updateDTO) {
        try {
            if (!personService.existsById(id)) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Person with ID: " + id + " not found.");
            }

            String response = personService.updatePerson(id, updateDTO);

            if (response != null) {
                return ResponseEntity.ok(response);
            } else {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
            }

        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid input: " + e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred: " + e.getMessage());
        }
    }

    // @RequestMapping(method = RequestMethod.GET, value = "/get/{id}")
    // Get person by id endpoint
    @GetMapping("/get/{id}")
    public ResponseEntity<Person> getPersonById(@PathVariable int id) {
        Person person = personService.getPersonById(id);

        if (person != null) {
            return ResponseEntity.ok(person);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // @RequestMapping(method = RequestMethod.GET, value = "/persons")
    // Get all persons endpoint
    @GetMapping("/persons")
    public ResponseEntity<List<Person>> getAllPersons() {
        return ResponseEntity.ok(personService.getAllPersons());
    }

    // @RequestMapping(method = RequestMethod.GET, value = "/persons/{firstName}")
    // all persons by first name endpoint
    @GetMapping("/persons/{firstName}")
    public ResponseEntity<?> getAllPersonsByFirstName(@PathVariable String firstName) {

        List<Person> persons = personService.findByFirstName(firstName);

        if (persons.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No persons found with the first name: " + firstName);
        } else {
            return ResponseEntity.ok(persons);
        }
    }

    // @RequestMapping(method = RequestMethod.DELETE, value = "/delete/{id}")
    // Delete person endpoint
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deletePerson(@PathVariable int id) {
        String responseMessage = personService.deletePersonById(id);

        if (responseMessage != null) {
            return ResponseEntity.ok(responseMessage);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Person by id " + id + " not found");
        }
    }
}
