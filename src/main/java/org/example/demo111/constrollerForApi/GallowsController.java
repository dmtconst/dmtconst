package org.example.demo111.constrollerForApi;

import org.example.demo111.dao.GallowsDao;
import org.example.demo111.entity.Words;
import org.example.demo111.service.WordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Random;

@Controller
public class GallowsController {
    GallowsDao gallowsDao;
    Model getWord;
    WordService wordService;

    @Autowired
    public GallowsController(GallowsDao gallowsDao, WordService wordService) {
        this.gallowsDao = gallowsDao;
        this.wordService = wordService;
    }

    @GetMapping("/gallows")
    public String getView() {
        return "/gallows/mainGallow" ;
    }

    @GetMapping("/startGame")
    public String startGame() {
        return "/gallows/startGame" ;
    }

    @GetMapping("/questions")
    public String questions(Model model) {
        Random rand = new Random();
        getWord = model.addAttribute("getWord", gallowsDao.getListWords().get(rand.nextInt(gallowsDao.getListWords().size())));

        return "/gallows/questions" ;
    }

    @PostMapping
    public String submitQuestion(Model model) {
        model.addAttribute("searchWord", getWord);
        return "/gallows/submitQuestion" ;
    }

    @GetMapping("/words")
    public String submitGallow(Model model) {
        model.addAttribute("getListWords", wordService.getWordsRepository().toString());
        return "/gallows/submitGallow" ;
    }


}
