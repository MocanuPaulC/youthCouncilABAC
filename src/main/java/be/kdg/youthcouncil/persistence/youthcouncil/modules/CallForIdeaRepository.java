package be.kdg.youthcouncil.persistence.youthcouncil.modules;

import be.kdg.youthcouncil.domain.youthcouncil.modules.CallForIdea;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CallForIdeaRepository extends JpaRepository<CallForIdea, Long> {
}
