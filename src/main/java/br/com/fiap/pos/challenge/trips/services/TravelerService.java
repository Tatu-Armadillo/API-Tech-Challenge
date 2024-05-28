package br.com.fiap.pos.challenge.trips.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.fiap.pos.challenge.trips.dto.traveler.TravelerDTO;
import br.com.fiap.pos.challenge.trips.exception.NotFoundException;
import br.com.fiap.pos.challenge.trips.models.Traveler;
import br.com.fiap.pos.challenge.trips.repositories.TravelerRepository;

@Service
public class TravelerService {

    private final TravelerRepository travelerRepository;
    private final UserService userService;

    @Autowired
    public TravelerService(TravelerRepository travelerRepository, final UserService userService) {
        this.travelerRepository = travelerRepository;
        this.userService = userService;
    }

    public Traveler findTravelerByName(final String name) {
        return this.travelerRepository
                .findTravelerByName(name)
                .orElseThrow(() -> new NotFoundException("Traveler with name: " + name));
    }

    public Page<Traveler> findTravelersByName(final Pageable pageable, final String travelerName) {
        return this.travelerRepository.findTravelersByName(pageable, travelerName);
    }

    public Traveler createTraveler(final TravelerDTO dto) {
        return this.travelerRepository.save(toEntity(dto));
    }

    private Traveler toEntity(final TravelerDTO dto) {
        final var entity = new Traveler();
        entity.setName(dto.name());
        entity.setEmail(dto.email());
        entity.setPhone(dto.phone());
        entity.setUsers(this.userService.createUser(dto.user()));
        return entity;
    }

}
