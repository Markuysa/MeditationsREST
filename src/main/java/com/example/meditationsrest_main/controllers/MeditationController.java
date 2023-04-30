package com.example.meditationsrest_main.controllers;


import com.example.meditationsrest_main.models.Meditation;
import com.example.meditationsrest_main.pojo.MeditationRequest;
import com.example.meditationsrest_main.service.MeditationService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/meditations")
@CrossOrigin(origins = "*")
public class MeditationController {

    public MeditationController(MeditationService meditationService) {
        this.meditationService = meditationService;
    }

    MeditationService meditationService;


    @GetMapping("/all")
    public List<Meditation> getAll(){
        return meditationService.getAll();
    }

    @GetMapping("/{id}")
    public Meditation getByID(@PathVariable Long id){
        return meditationService.getByID(id);
    }

    @PostMapping("/create")
    @PreAuthorize("hasAnyRole('ADMIN','MODERATOR')")
    public ResponseEntity<Meditation> createMeditation(@RequestBody MeditationRequest meditationRequest) throws Throwable {
        Meditation meditation = meditationService.createMeditation(meditationRequest);
        return ResponseEntity.created(URI.create("/api/meditations/" + meditation.getId())).body(meditation);
    }
    @PostMapping("/delete/{id}")
    @PreAuthorize("hasAnyRole('ADMIN','MODERATOR')")
    public void deleteMeditation(@PathVariable Long id){
        meditationService.deleteById(id);
    }
}
