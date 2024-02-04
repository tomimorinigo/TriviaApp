package com.tomasmorinigo.triviabackend.persistence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tomasmorinigo.triviabackend.persistence.entities.EntertainmentQuestion;

public interface EntertainmentRepository extends JpaRepository<EntertainmentQuestion, Long>{
    
}
