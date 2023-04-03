package be.kdg.youthcouncil.persistence;

import be.kdg.youthcouncil.domain.youthcouncil.modules.CallForIdea;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CallForIdeaRepository extends JpaRepository<CallForIdea, Long> {
}
