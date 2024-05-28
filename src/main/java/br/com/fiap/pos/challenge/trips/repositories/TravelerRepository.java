package br.com.fiap.pos.challenge.trips.repositories;

import br.com.fiap.pos.challenge.trips.models.Traveler;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TravelerRepository extends JpaRepository<Traveler, Long> {

    Optional<Traveler> findTravelerByName(@Param("name") String name);

    @Query(" SELECT traveler FROM Traveler traveler " +
            " WHERE UPPER(traveler.name) LIKE UPPER(CONCAT('%', :name, '%')) ")
    Page<Traveler> findTravelersByName(Pageable pageable, @Param("name") String name);
}
