package com.tomasmorinigo.triviabackend.services.Entertainment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tomasmorinigo.triviabackend.persistence.entities.EntertainmentQuestion;
import com.tomasmorinigo.triviabackend.persistence.repositories.EntertainmentRepository;

import java.util.Optional;
import java.util.Random;

@Service
public class EntertainmentServiceImp implements EntertainmentService {
    
    @Autowired
    private EntertainmentRepository entertainmentRepository;

    @Override
    @Transactional(readOnly = true)
    public Optional<EntertainmentQuestion> getRandomQuestion() {
        Long randomId = (long) (new Random().nextInt(10) + 1);
        
        // Pasar el ID aleatorio al repositorio
        Optional<EntertainmentQuestion> question = entertainmentRepository.findById(randomId);
        
        return question;
    }

}
