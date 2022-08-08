package challenge.hiring.verifone.sim.card.api.repositories;

import challenge.hiring.verifone.sim.card.api.domain.SimCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SimCardRepository extends JpaRepository<SimCard, Long> {
}
