package org.example.demo111.controllers;

import org.example.demo111.dao.PersonDao;
import org.example.demo111.models.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/people")
public class PersonController {

    private final PersonDao personDAO;

    @Autowired
    public PersonController(PersonDao personDAO) {
        this.personDAO = personDAO;
    }

    @GetMapping()
    public String index(Model model) {
        model.addAttribute("peopleList", personDAO.index());
        return "person/index";
    }

    @GetMapping("/{id}")
    public String getPersonById(@PathVariable("id") int id, Model model) {
        model.addAttribute("person", personDAO.show(id));
        return "person/getPersonById";
    }

    @GetMapping("/new")
    public String newPerson(Model model) {
        model.addAttribute("new_person", new Person());
        return "person/newPerson";
    }

    @PostMapping
    public String createPerson(@ModelAttribute("person") Person person) {
        personDAO.savePerson(person);
        return "person/ok";
    }

    @PostMapping("/666")
    public String createPerson666(@ModelAttribute("person") Person person) {
        personDAO.savePerson(person);
        return "person/ok666";
    }
}
