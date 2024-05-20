package br.com.fiap.pos.challenge.trips.repositories;

import br.com.fiap.pos.challenge.trips.models.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Long> {
}
