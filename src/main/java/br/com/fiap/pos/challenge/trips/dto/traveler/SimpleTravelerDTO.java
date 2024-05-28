package br.com.fiap.pos.challenge.trips.dto.traveler;

import br.com.fiap.pos.challenge.trips.models.Traveler;

public record SimpleTravelerDTO(
                String name,
                String username,
                String email) {

        public static SimpleTravelerDTO of(final Traveler entity) {
                return new SimpleTravelerDTO(
                                entity.getName(),
                                entity.getUsers().getUsername(),
                                entity.getEmail());
        }
}
