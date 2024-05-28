package br.com.fiap.pos.challenge.trips.dto.traveler;

import br.com.fiap.pos.challenge.trips.models.Traveler;

public record TravelerDTO(
                String name,
                String phone,
                String email,
                UserDTO user) {

        public static TravelerDTO of(final Traveler entity) {
                return new TravelerDTO(
                                entity.getName(),
                                entity.getPhone(),
                                entity.getEmail(),
                                UserDTO.of(entity.getUsers()));
        }

}
