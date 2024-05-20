package br.com.fiap.pos.challenge.trips.repositories;

import br.com.fiap.pos.challenge.trips.models.Comments;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentsRepository extends JpaRepository<Comments, Long> {
}
