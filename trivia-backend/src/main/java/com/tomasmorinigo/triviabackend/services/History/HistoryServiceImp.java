package com.tomasmorinigo.triviabackend.services.History;

import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tomasmorinigo.triviabackend.persistence.entities.HistoryQuestion;
import com.tomasmorinigo.triviabackend.persistence.repositories.HistoryRepository;

@Service
public class HistoryServiceImp implements HistoryService{

    @Autowired
    private HistoryRepository historyRepository;

    @Override
    @Transactional(readOnly = true)
    public Optional<HistoryQuestion> getRandomQuestion() {
        Long randomId = (long) (new Random().nextInt(10) + 1);
        Optional<HistoryQuestion> question = historyRepository.findById(randomId);
        
        return question;
    }
}
