package com.example.meditationsrest_main.repository;

import java.util.Optional;

import com.example.meditationsrest_main.models.ERole;
import com.example.meditationsrest_main.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RoleRepository extends JpaRepository<Role, Long>{
	Optional<Role> findByName(ERole name);
}
