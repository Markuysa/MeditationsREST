package com.example.meditationsrest_main.service;

import com.example.meditationsrest_main.models.Meditation;
import com.example.meditationsrest_main.repository.MeditationRepository;
import com.example.meditationsrest_main.repository.UserRepository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Set;

@Service
public class MeditationService {

    MeditationRepository meditationRepository;
    UserRepository userRepository;


    public MeditationService(MeditationRepository meditationRepository, UserRepository userRepository) {
        this.meditationRepository = meditationRepository;
        this.userRepository=userRepository;
    }

    public List<Meditation> getAll(){
        return meditationRepository.findAll();
    }

    public Meditation getByID(Long id){
        return meditationRepository.getReferenceById(id);
    }
    public Meditation add(Meditation meditation){
        return meditationRepository.save(meditation);
    }


}
