package Repositories;

import entities.Viaggio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface RepositoryViaggio extends JpaRepository<Viaggio, UUID> {
}
