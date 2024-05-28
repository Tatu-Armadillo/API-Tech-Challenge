package br.com.fiap.pos.challenge.trips.services;

import br.com.fiap.pos.challenge.trips.dto.traveler.UserDTO;
import br.com.fiap.pos.challenge.trips.models.User;
import br.com.fiap.pos.challenge.trips.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(final UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User createUser(final UserDTO dto) {
        return this.userRepository.save(toEntity(dto));
    }

    private User toEntity(final UserDTO dto) {
        final var entity = new User();
        entity.setUsername(dto.username());
        entity.setPassword(dto.password());
        return entity;
    }
}
