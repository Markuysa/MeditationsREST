package com.example.meditationsrest_main.controllers;

import com.example.meditationsrest_main.models.Meditation;
import com.example.meditationsrest_main.service.MeditationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    @Autowired
    private MeditationService meditationService;

    @GetMapping("/{categoryName}/meditations")
    public ResponseEntity<List<Meditation>> getMeditationsByCategory(@PathVariable String categoryName) {
        List<Meditation> meditations = meditationService.getMeditationsByCategory(categoryName);
        if (meditations.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(meditations, HttpStatus.OK);
    }
}