package br.com.fiap.pos.challenge.trips.repositories;


import br.com.fiap.pos.challenge.trips.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SampleRepository extends JpaRepository<User,Long> {
}
