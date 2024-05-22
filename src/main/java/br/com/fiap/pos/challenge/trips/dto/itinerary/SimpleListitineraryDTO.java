package br.com.fiap.pos.challenge.trips.dto.itinerary;

import java.math.BigDecimal;

import br.com.fiap.pos.challenge.trips.models.Itinerary;

public record SimpleListitineraryDTO(
        Long id,
        BigDecimal moneyQuantity,
        String nameCity) {

    public static SimpleListitineraryDTO of(final Itinerary entity) {
        return new SimpleListitineraryDTO(
                entity.getIdItinerary(),
                entity.getMoneyQuantity(),
                entity.getCity().getName());
    }

}
