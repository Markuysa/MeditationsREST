package com.example.meditationsrest_main.repository;

import com.example.meditationsrest_main.models.Meditation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MeditationRepository extends JpaRepository<Meditation, Long> {


    Meditation getReferenceById(Long id);
    void deleteMeditationById(Long id);

    List<Meditation> findByCategories_Name(String categoryName);
}
