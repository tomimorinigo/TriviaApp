package com.tomasmorinigo.triviabackend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
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
    public SportQuestion getRandomQuestion() {
        return sportService.getRandomQuestion().get();
    }

}
