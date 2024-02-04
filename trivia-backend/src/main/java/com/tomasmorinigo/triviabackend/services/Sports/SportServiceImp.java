package com.tomasmorinigo.triviabackend.services.Sports;

import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tomasmorinigo.triviabackend.persistence.entities.SportQuestion;
import com.tomasmorinigo.triviabackend.persistence.repositories.SportRepository;

@Service
public class SportServiceImp implements SportService{
    
    @Autowired
    private SportRepository sportsRepository;

    @Override
    public Optional<SportQuestion> getRandomQuestion() {
        Long randomId = (long) (new Random().nextInt(10) + 1);
        Optional<SportQuestion> question = sportsRepository.findById(randomId);
        
        return question;
    }

}
