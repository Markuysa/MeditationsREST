package com.example.meditationsrest_main.service;


import com.example.meditationsrest_main.models.Meditation;
import com.example.meditationsrest_main.models.User;
import com.example.meditationsrest_main.repository.MeditationRepository;
import com.example.meditationsrest_main.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import javax.persistence.EntityNotFoundException;
import java.util.Set;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	UserRepository userRepository;
	@Autowired
	MeditationRepository meditationRepository;

	@Override
	@Transactional
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findByUsername(username)
				.orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + username));
		return UserDetailsImpl.build(user);
	}

	@Transactional
	public UserDetails loadUserById(Long id) throws UsernameNotFoundException {
		User user = userRepository.findById(id)
				.orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + id));
		return UserDetailsImpl.build(user);
	}

	@Transactional
	public void addMeditationToFavorites(Long userId, Long meditationId) {
		User user = userRepository.findById(userId).orElseThrow(() -> new EntityNotFoundException("User not found"));
		Meditation meditation = meditationRepository.findById(meditationId).orElseThrow(() -> new EntityNotFoundException("Meditation not found"));
		user.getFavorites().add(meditation);
		userRepository.save(user);
	}

	@Transactional(readOnly = true)
	public Set<Meditation> getFavorites(Long userId) {
		User user = userRepository.findById(userId).orElseThrow(() -> new EntityNotFoundException("User not found"));
		return user.getFavorites();
	}

}
