package com.example.meditationsrest_main.controllers;

import com.example.meditationsrest_main.models.Meditation;
import com.example.meditationsrest_main.service.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "*")
public class UserController {

    @Autowired
    private UserDetailsServiceImpl userService;

    @PostMapping("/{userId}/favorites/{meditationId}")
    @PreAuthorize("hasAnyRole('USER','ADMIN','MODERATOR')")
    public void addMeditationToFavorites(@PathVariable Long userId, @PathVariable Long meditationId) {
        userService.addMeditationToFavorites(userId, meditationId);
    }

    @GetMapping("/{userId}/favorites")
    @PreAuthorize("hasAnyRole('USER','ADMIN','MODERATOR')")
    public Set<Meditation> getFavorites(@PathVariable Long userId) {
        return userService.getFavorites(userId);
    }
    @GetMapping("/{userId}")
    public UserDetails getUser(@PathVariable Long userId) {
        return userService.loadUserById(userId);
    }
}