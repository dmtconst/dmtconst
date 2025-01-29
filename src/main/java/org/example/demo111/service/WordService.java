package org.example.demo111.service;

import org.example.demo111.entity.Words;
import org.example.demo111.repository.WordsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class WordService {
    private final WordsRepository wordsRepository;

    @Autowired
    public WordService(WordsRepository wordsRepository) {
        this.wordsRepository = wordsRepository;
        System.out.println();
    }

    public List<Words> getWordsRepository() {
        return wordsRepository.findAll();
    }

    public Words createWord(Words words) {
        return wordsRepository.save(words);  // Создать новую запись
    }

    public String dellWordById(int wordId) {
        wordsRepository.deleteById(wordId);
        return "Удален word c id = " + wordId;
    }

    @Transactional
    public String updateWord(int id, String v) {
        Optional<Words> wordOptional = wordsRepository.findById(id);
        wordOptional.get().setDescription(v);
        return "обновилось поле " + v;
    }
}
