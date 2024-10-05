
package com.example.api_rest.Person;

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
        personService.createPerson(person);
        return "Welcome " + person.getFirstName() + " " + person.getLastName();
    }

    // Update person endpoint
    @PatchMapping("/update/{id}")
    public ResponseEntity<Person> updatePerson(
            @PathVariable int id,
            @RequestBody Person updateDTO) {

        Person updatedPerson = personService.updatePerson(id, updateDTO);

        if (updatedPerson == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(updatedPerson);
    }

    // Get person by id endpoint
    @GetMapping("/get/{id}")
    public Person getPersonById(@PathVariable int id) {
        return personService.getPersonById(id);
    }

    // Delete person endpoint
    @PostMapping("/delete/{id}")
    public String deletePerson(@PathVariable int id) {
        personService.deletePersonById(id);
        return "Person deleted successfully";
    }

}
