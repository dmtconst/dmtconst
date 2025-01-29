package org.example.demo111.repository;

import org.example.demo111.entity.Words;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WordsRepository extends JpaRepository<Words, Integer> {

}
