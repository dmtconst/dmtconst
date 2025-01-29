package org.example.demo111.constrollerForApi;

import org.example.demo111.dao.PersonDao;
import org.example.demo111.dto.Plan;
import org.example.demo111.entity.Words;
import org.example.demo111.models.Person;
import org.example.demo111.service.WordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BoxController {
    private final WordService wordService;

    @Autowired
    public BoxController(WordService wordService) {
        this.wordService = wordService;
    }

    @GetMapping("/{list}")
    public String getList(@PathVariable String list) {
        return list;
    }

    @GetMapping("/list")
    public List<Person> getPersonList() {
        PersonDao personDao = new PersonDao();
        return personDao.index();
    }

    @PostMapping("/createPlan")
    public String postPlan(@RequestBody Plan plan) {
        return plan.toString();
    }

    @GetMapping("/000")
    public List<Plan> getPlan() {
        return List.of(new Plan("купить", "что та"),
                new Plan("продао ть", "ког"));
    }

    @GetMapping("/1111")
    public List<Words> getWords() {
        return wordService.getWordsRepository();
    }

    @PostMapping("/createWww")
    public Words createGallow(@RequestBody Words words) {
        return wordService.createWord(words);
    }

    @DeleteMapping("/{wordId}")
    public String deleteWord(@PathVariable int wordId) {
        return wordService.dellWordById(wordId);
    }

    @PutMapping("/{id}")
    public String updateWord(@PathVariable int id,
                             @RequestBody (required = false) String v) {
        return wordService.updateWord(id, v);
    }

}
