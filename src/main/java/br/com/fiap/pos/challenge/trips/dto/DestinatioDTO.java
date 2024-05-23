package br.com.fiap.pos.challenge.trips.dto;

import br.com.fiap.pos.challenge.trips.models.City;

public record DestinatioDTO(
        String city,
        String state,
        String country) {

    public static DestinatioDTO of(final City entity) {
        return new DestinatioDTO(
                entity.getName(),
                entity.getState().getName(),
                entity.getState().getCountry().getPortugueseName());
    }
}
