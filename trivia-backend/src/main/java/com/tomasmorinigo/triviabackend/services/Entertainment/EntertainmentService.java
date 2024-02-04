package com.tomasmorinigo.triviabackend.services.Entertainment;

import java.util.Optional;

import com.tomasmorinigo.triviabackend.persistence.entities.EntertainmentQuestion;

public interface EntertainmentService {
    public Optional<EntertainmentQuestion> getRandomQuestion();
}
