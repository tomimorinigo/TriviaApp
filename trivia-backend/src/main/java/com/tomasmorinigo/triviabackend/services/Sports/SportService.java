package com.tomasmorinigo.triviabackend.services.Sports;

import java.util.Optional;

import com.tomasmorinigo.triviabackend.persistence.entities.SportQuestion;

public interface SportService {
    public Optional<SportQuestion> getRandomQuestion();
}
