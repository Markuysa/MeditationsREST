package com.example.meditationsrest_main.repository;

import com.example.meditationsrest_main.models.Meditation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MeditationRepository extends JpaRepository<Meditation, Long> {


    Meditation getReferenceById(Long id);
}
