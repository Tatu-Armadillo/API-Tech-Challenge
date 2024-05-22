package br.com.fiap.pos.challenge.trips.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fiap.pos.challenge.trips.models.Traveler;
import br.com.fiap.pos.challenge.trips.repositories.TravelerRepository;

@Service
public class TravelerService {

    private final TravelerRepository travelerRepository;

    @Autowired
    public TravelerService(TravelerRepository travelerRepository) {
        this.travelerRepository = travelerRepository;
    }

    public Traveler findTravelerByName(final String name) {
        return this.travelerRepository.findTravelerByName(name).orElseThrow();
    }

}
