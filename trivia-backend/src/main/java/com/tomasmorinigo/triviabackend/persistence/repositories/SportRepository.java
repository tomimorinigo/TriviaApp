package com.tomasmorinigo.triviabackend.persistence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tomasmorinigo.triviabackend.persistence.entities.SportQuestion;

public interface SportRepository extends JpaRepository<SportQuestion, Long>{
    
}
