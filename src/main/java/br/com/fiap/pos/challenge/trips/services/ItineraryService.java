package br.com.fiap.pos.challenge.trips.services;

import java.time.LocalDateTime;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fiap.pos.challenge.trips.dto.itinerary.ItineraryDTO;
import br.com.fiap.pos.challenge.trips.exception.NotFoundException;
import br.com.fiap.pos.challenge.trips.models.Itinerary;
import br.com.fiap.pos.challenge.trips.repositories.ItineraryRepository;

@Service
public class ItineraryService {

    private final ItineraryRepository itineraryRepository;
    private final DestinationService destinationService;
    private final TravelerService travelerService;

    @Autowired
    public ItineraryService(
            final ItineraryRepository itineraryRepository,
            final DestinationService destinationService,
            final TravelerService travelerService) {
        this.itineraryRepository = itineraryRepository;
        this.destinationService = destinationService;
        this.travelerService = travelerService;
    }

    public Itinerary createItinerary(final ItineraryDTO dto) {
        final var entity = this.toEntity(dto);
        return this.itineraryRepository.save(entity);
    }

    public Itinerary findById(final Long id) {
        return this.itineraryRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Itinerary with id: " + id));
    }

    public Page<Itinerary> pageItinerariesWithFilter(
            final Pageable pageable,
            final String filter) {
        return this.itineraryRepository.pageItinerariesWithFilter(filter, pageable);
    }

    private Itinerary toEntity(final ItineraryDTO dto) {
        final var entity = new Itinerary();
        entity.setResume(dto.resume());
        entity.setShared(dto.shared());
        entity.setMoneyQuantity(dto.moneyQuantity());
        entity.setDepartureDate(dto.departureDate());
        entity.setReturnDate(dto.returnDate());
        entity.setCrateDate(LocalDateTime.now());
        entity.setTraveler(this.travelerService.findTravelerByName(dto.travelerName()));
        entity.setCity(this.destinationService.findCityByName(dto.nameCity()));
        return entity;
    }

}
