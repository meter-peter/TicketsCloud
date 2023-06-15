package meter_peter.ticketscloud;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface DVDRepository extends JpaRepository<DVD, UUID> {
    Optional<DVD> findByTitle(String title);
}