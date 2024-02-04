package com.tomasmorinigo.triviabackend.persistence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tomasmorinigo.triviabackend.persistence.entities.HistoryQuestion;

public interface HistoryRepository extends JpaRepository<HistoryQuestion, Long>{
    
}
