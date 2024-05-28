package br.com.fiap.pos.challenge.trips.dto.traveler;

import br.com.fiap.pos.challenge.trips.models.User;

public record UserDTO(
                String username,
                String password) {

        public static UserDTO of(final User entity) {
                return new UserDTO(entity.getUsername(), entity.getPassword());
        }
}
