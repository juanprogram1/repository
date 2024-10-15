package com.example.api_rest.Person;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
        ResponseEntity.ok(personService.createPerson(person));
        return ResponseEntity.ok(person);
    }

    // Update person endpoint
    // @RequestMapping(method = RequestMethod.PUT, value = "/update/{id}")
    @PutMapping("/update/{id}")
    public ResponseEntity<String> updatePerson(@PathVariable int id, @RequestBody PersonUpdateDTO updateDTO) {
        String responseMessage = personService.updatePerson(id, updateDTO);

        if (responseMessage.equals("Update successful")) {
            return ResponseEntity.ok(responseMessage);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(responseMessage);
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
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

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
    public ResponseEntity<List<Person>> getAllPersonsByFirstName(@PathVariable String firstName) {
        return ResponseEntity.ok(personService.getAllPersonsByFirstName(firstName));
    }

    // @RequestMapping(method = RequestMethod.DELETE, value = "/delete/{id}")
    // Delete person endpoint
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deletePerson(@PathVariable int id) {
        String responseMessage = personService.deletePersonById(id);

        if (responseMessage != null) {
            return ResponseEntity.ok(responseMessage);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(responseMessage);
        }
    }
}
