package com.tomasmorinigo.triviabackend.services.History;

import java.util.Optional;

import com.tomasmorinigo.triviabackend.persistence.entities.HistoryQuestion;

public interface HistoryService {
    public Optional<HistoryQuestion> getRandomQuestion();
}
