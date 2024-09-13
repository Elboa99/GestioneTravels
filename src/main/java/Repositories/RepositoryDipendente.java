package Repositories;



import entities.Dipendente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.UUID;

@Repository
public interface RepositoryDipendente extends JpaRepository<Dipendente, UUID> {
}