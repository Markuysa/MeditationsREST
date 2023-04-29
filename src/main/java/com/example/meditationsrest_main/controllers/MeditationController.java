package com.example.meditationsrest_main.controllers;


import com.example.meditationsrest_main.models.Meditation;
import com.example.meditationsrest_main.pojo.MeditationRequest;
import com.example.meditationsrest_main.service.MeditationService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/meditations")
public class MeditationController {

    public MeditationController(MeditationService meditationService) {
        this.meditationService = meditationService;
    }

    MeditationService meditationService;


    @GetMapping("/getall")
    @PreAuthorize("hasAnyRole('USER','ADMIN','MODERATOR')")
    public List<Meditation> getAll(){
        return meditationService.getAll();
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('USER','ADMIN','MODERATOR')")
    public Meditation getByID(@PathVariable Long id){
        return meditationService.getByID(id);
    }

    @PostMapping("/add")
    @PreAuthorize("hasAnyRole('ADMIN','MODERATOR')")
    public Meditation addMeditation(@RequestBody MeditationRequest requestBody){
        var meditation = new Meditation(
                requestBody.image,
                requestBody.videourl,
                requestBody.description,
                (float) 12.2);
        System.out.println(meditation);
        return meditationService.add(meditation);
    }




}
