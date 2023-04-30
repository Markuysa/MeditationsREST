package com.example.meditationsrest_main.repository;

import com.example.meditationsrest_main.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category,Long> {

    Category findByName(String name);
}
