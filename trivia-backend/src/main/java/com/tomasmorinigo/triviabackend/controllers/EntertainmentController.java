package com.tomasmorinigo.triviabackend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tomasmorinigo.triviabackend.persistence.entities.EntertainmentQuestion;
import com.tomasmorinigo.triviabackend.services.Entertainment.EntertainmentService;

@RestController
@RequestMapping("/api/entertainment")
public class EntertainmentController {
    
    @Autowired
    private EntertainmentService entertainmentService;

    @GetMapping("/random")
    public EntertainmentQuestion getRandomQuestion() {
        return entertainmentService.getRandomQuestion().get();
    }

}
