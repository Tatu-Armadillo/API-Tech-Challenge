package br.com.fiap.pos.challenge.trips.repositories;

import br.com.fiap.pos.challenge.trips.models.Traveler;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TravelerRepository extends JpaRepository<Traveler, Long> {
}
