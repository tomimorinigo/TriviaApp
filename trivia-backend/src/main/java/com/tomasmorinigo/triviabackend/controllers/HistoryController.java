package com.tomasmorinigo.triviabackend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tomasmorinigo.triviabackend.persistence.entities.HistoryQuestion;
import com.tomasmorinigo.triviabackend.services.History.HistoryService;

@RestController
@RequestMapping("/api/history")
public class HistoryController {
    
    @Autowired
    private HistoryService historyService;

    @GetMapping("/random")
    public HistoryQuestion getRandomQuestion() {
        return historyService.getRandomQuestion().get();
    }

}
