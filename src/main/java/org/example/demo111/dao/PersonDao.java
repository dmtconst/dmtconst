package org.example.demo111.dao;

import org.example.demo111.models.Person;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PersonDao {
    private static int ID_PERSON;
    List<Person> people;

    public PersonDao() {
        people = new ArrayList<>();
        people.add(new Person(++ID_PERSON, "Max"));
        people.add(new Person(++ID_PERSON, "Jack"));
        people.add(new Person(++ID_PERSON, "Mary"));
        people.add(new Person(++ID_PERSON, "Bob"));
    }


    public List<Person> index() {
        return people;
    }

    public Person show(int id) {
        return people.stream()
                .filter(person -> person.getId() == id)
                .findFirst().orElse(null);
    }


    public void savePerson(Person person) {
        person.setId(++ID_PERSON);
        people.add(person);
    }
}
