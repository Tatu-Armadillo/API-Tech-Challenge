package br.com.fiap.pos.challenge.trips.repositories;

import br.com.fiap.pos.challenge.trips.models.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country, Long> {
}
