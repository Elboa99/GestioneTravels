package Repositories;

import entities.Prenotazione;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface RepositoryPrenotazione extends JpaRepository<Prenotazione, UUID> {

}