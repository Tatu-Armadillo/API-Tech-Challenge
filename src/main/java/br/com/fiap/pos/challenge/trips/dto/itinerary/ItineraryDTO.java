package br.com.fiap.pos.challenge.trips.dto.itinerary;

import java.math.BigDecimal;
import java.time.LocalDate;

import br.com.fiap.pos.challenge.trips.models.Itinerary;

public record ItineraryDTO(
        String travelerName,
        String resume,
        boolean shared,
        BigDecimal moneyQuantity,
        LocalDate departureDate,
        LocalDate returnDate,
        String nameCity) {

    public static ItineraryDTO of(final Itinerary entity) {
        return new ItineraryDTO(
                entity.getTraveler().getName(),
                entity.getResume(),
                entity.isShared(),
                entity.getMoneyQuantity(),
                entity.getDepartureDate(),
                entity.getReturnDate(),
                entity.getCity().getName());
    }

}
