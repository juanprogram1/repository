
package com.example.api_rest.Person;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/api/person")
@RequiredArgsConstructor
public class PersonController {

    private final PersonService personService;

    // Create person endpoint
    @PostMapping("/create")
    public String createPerson(@RequestBody Person person) {
        personService.createPerson(person);
        return "Person created successfully";
    }

    // Find person by email endpoint
    @GetMapping("/search")
    public List<Person> findPersonByFirstName(@RequestParam String firstName) {
        return personService.findPersonByFirstName(firstName);
    }

}
