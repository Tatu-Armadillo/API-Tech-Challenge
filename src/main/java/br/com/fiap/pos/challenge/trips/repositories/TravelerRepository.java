package br.com.fiap.pos.challenge.trips.repositories;

import br.com.fiap.pos.challenge.trips.models.Traveler;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

public interface TravelerRepository extends JpaRepository<Traveler, Long> {

    Optional<Traveler> findTravelerByName(@Param("name") String name);
}
