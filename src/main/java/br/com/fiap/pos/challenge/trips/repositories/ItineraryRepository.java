package br.com.fiap.pos.challenge.trips.repositories;

import br.com.fiap.pos.challenge.trips.models.Itinerary;

import org.springframework.data.domain.*;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;

public interface ItineraryRepository extends JpaRepository<Itinerary, Long> {

    @Query("  SELECT itinerary FROM Itinerary itinerary         " +
            " INNER JOIN itinerary.city city                    " +
            " INNER JOIN city.state state                       " +
            " INNER JOIN state.country country                  " +
            " WHERE itinerary.shared = true                     " +
            " AND (:filter IS NULL OR :filter = ''              " +
            " OR UPPER(country.portugueseName) = UPPER(:filter) " +
            " OR UPPER(country.englishName) = UPPER(:filter)    " +
            " OR UPPER(state.uf) = UPPER(:filter)               " +
            " OR UPPER(state.name) = UPPER(:filter)             " +
            " OR (UPPER(city.name) = UPPER(:filter)))           ")
    Page<Itinerary> pageItinerariesWithFilter(@Param("filter") String filter, Pageable pageable);

}
