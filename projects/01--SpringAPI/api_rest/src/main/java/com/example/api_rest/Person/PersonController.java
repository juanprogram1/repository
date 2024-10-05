package com.example.api_rest.Person;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/person")
@RequiredArgsConstructor
public class PersonController {

    private final PersonService personService;

    // Create person endpoint
    @PostMapping("/create")
    public String createPerson(@RequestBody Person person) {
        return personService.createPerson(person);
    }

    // Update person endpoint
    @PutMapping("/update/{id}")
    public ResponseEntity<String> updatePerson(@PathVariable int id, @RequestBody PersonUpdateDTO updateDTO) {
        String responseMessage = personService.updatePerson(id, updateDTO);

        if (responseMessage.equals("Update successful")) {
            return ResponseEntity.ok(responseMessage);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(responseMessage);
        }
    }

    // Get person by id endpoint
    @GetMapping("/get/{id}")
    public ResponseEntity<String> getPersonById(@PathVariable int id) {
        String person = personService.getPersonById(id);
        if (person != null) {
            return ResponseEntity.ok(person);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        }
    }

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
