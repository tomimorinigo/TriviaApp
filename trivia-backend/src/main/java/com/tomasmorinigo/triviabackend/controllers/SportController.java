package com.tomasmorinigo.triviabackend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tomasmorinigo.triviabackend.persistence.entities.SportQuestion;
import com.tomasmorinigo.triviabackend.services.Sports.SportService;

@RestController
@RequestMapping("/api/sports")
public class SportController {

    @Autowired
    private SportService sportService;

    @GetMapping("/random")
    public ResponseEntity<SportQuestion> getRandomQuestion() {
        SportQuestion sportQuestion = sportService.getRandomQuestion().get();
        if (sportQuestion != null) {
            return ResponseEntity.ok().body(sportQuestion);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
