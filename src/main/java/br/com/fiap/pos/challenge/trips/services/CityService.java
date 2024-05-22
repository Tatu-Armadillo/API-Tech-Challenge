package br.com.fiap.pos.challenge.trips.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fiap.pos.challenge.trips.exception.NotFoundException;
import br.com.fiap.pos.challenge.trips.models.City;
import br.com.fiap.pos.challenge.trips.repositories.CityRepository;

@Service
public class CityService {

    private final CityRepository cityRepository;

    @Autowired
    public CityService(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    public City findCityByName(final String name) {
        return this.cityRepository
        .findCityByName(name)
        .orElseThrow(() -> new NotFoundException("City with name: " + name));
    }

}
