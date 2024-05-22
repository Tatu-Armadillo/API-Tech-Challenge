package br.com.fiap.pos.challenge.trips.services;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fiap.pos.challenge.trips.dto.ItineraryDTO;
import br.com.fiap.pos.challenge.trips.models.Itinerary;
import br.com.fiap.pos.challenge.trips.repositories.ItineraryRepository;

@Service
public class ItineraryService {

    private final ItineraryRepository itineraryRepository;
    private final CityService cityService;
    private final TravelerService travelerService;

    @Autowired
    public ItineraryService(
            final ItineraryRepository itineraryRepository,
            final CityService cityService,
            final TravelerService travelerService) {
        this.itineraryRepository = itineraryRepository;
        this.cityService = cityService;
        this.travelerService = travelerService;
    }

    public Itinerary createItinerary(final ItineraryDTO dto) {
        final var entity = this.toEntity(dto);
        return this.itineraryRepository.save(entity);
    }

    private Itinerary toEntity(final ItineraryDTO dto) {
        final var entity = new Itinerary();
        entity.setResume(dto.resume());
        entity.setShared(dto.shared());
        entity.setMoneyQuantity(dto.moneyQuantity());
        entity.setDepartureDate(dto.departureDate());
        entity.setReturnDate(dto.returnDate());
        entity.setCrateDate(LocalDateTime.now());
        entity.setCity(this.cityService.findCityByName(dto.nameCity()));
        entity.setTraveler(this.travelerService.findTravelerByName(dto.travelerName()));
        return entity;
    }

}
