package br.com.fiap.pos.challenge.trips.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.fiap.pos.challenge.trips.exception.NotFoundException;
import br.com.fiap.pos.challenge.trips.models.City;
import br.com.fiap.pos.challenge.trips.repositories.DestinationRepository;

@Service
public class DestinationService {

    private final DestinationRepository cityRepository;

    @Autowired
    public DestinationService(DestinationRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    public Page<City> pageDestinationsWithFilter(final Pageable pageable, final String filter) {
        return this.cityRepository.pageDestinationsWithFilter(pageable, filter);
    }

    public City findCityByName(final String name) {
        return this.cityRepository
                .findCityByName(name)
                .orElseThrow(() -> new NotFoundException("City with name: " + name));
    }

}
