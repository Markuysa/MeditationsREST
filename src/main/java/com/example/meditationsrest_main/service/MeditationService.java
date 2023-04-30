package com.example.meditationsrest_main.service;

import com.example.meditationsrest_main.controllers.MeditationController;
import com.example.meditationsrest_main.exceptions.ResourceNotFoundException;
import com.example.meditationsrest_main.models.Category;
import com.example.meditationsrest_main.models.Meditation;
import com.example.meditationsrest_main.pojo.MeditationRequest;
import com.example.meditationsrest_main.repository.CategoryRepository;
import com.example.meditationsrest_main.repository.MeditationRepository;
import com.example.meditationsrest_main.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.HashSet;
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
//    public Meditation createMeditation(MeditationRequest meditationRequest) {
//        Meditation meditation = new Meditation();
//        meditation.setImage(meditationRequest.getImage());
//        meditation.setVideo(meditationRequest.getVideo());
//        meditation.setDescription(meditationRequest.getDescription());
//        meditation.setRating(meditationRequest.getRating());
//
//        return meditationRepository.save(meditation);
//    }


    public void deleteById(Long meditaionID) {
        meditationRepository.deleteById(meditaionID);
    }


    @Autowired
    private CategoryRepository categoryRepository;

    public Meditation createMeditation(MeditationRequest meditationRequest){
        Meditation meditation = new Meditation();
        meditation.setImage(meditationRequest.getImage());
        meditation.setVideo(meditationRequest.getVideo());
        meditation.setDescription(meditationRequest.getDescription());
        meditation.setRating(meditationRequest.getRating());

        // add categories
        Set<Category> categories = new HashSet<>();
        for (String categoryName : meditationRequest.getCategories()) {
            Category category = categoryRepository.findByName(categoryName);
            if (category==null){
                return new Meditation();
            }
            categories.add(category);
        }
        meditation.setCategories(categories);

        return meditationRepository.save(meditation);
    }

    public List<Meditation> getMeditationsByCategory(String categoryName){
        Category category = categoryRepository.findByName(categoryName);
        if (category==null){
            return new ArrayList<Meditation>();
        }
        return meditationRepository.findByCategories_Name(category.getName());
    }
}
