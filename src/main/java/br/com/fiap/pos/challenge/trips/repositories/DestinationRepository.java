package br.com.fiap.pos.challenge.trips.repositories;

import br.com.fiap.pos.challenge.trips.models.City;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface DestinationRepository extends JpaRepository<City, Long> {

    @Query("  SELECT city FROM City city                        " +
            " INNER JOIN city.state state                       " +
            " INNER JOIN state.country country                  " +
            " WHERE :filter IS NULL OR :filter = ''             " +
            " OR UPPER(country.portugueseName) = UPPER(:filter) " +
            " OR UPPER(state.name) = UPPER(:filter)             " +
            " OR UPPER(city.name) = UPPER(:filter)              ")
    Page<City> pageDestinationsWithFilter(Pageable pageable, @Param("filter") String filter);

    Optional<City> findCityByName(@Param("name") String name);

}
