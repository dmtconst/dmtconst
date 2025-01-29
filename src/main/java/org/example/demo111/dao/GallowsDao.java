package org.example.demo111.dao;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class GallowsDao {
    List<String> listWords = new ArrayList<>();


    public GallowsDao() {
        listWords.add("ЖОПА");
        listWords.add("ПИЗДА");
        listWords.add("ОЧКО");
    }

    public List<String> getListWords() {
        return listWords;
    }

}
