package be.kdg.youthcouncil.persistence.youthcouncil.modules;

import be.kdg.youthcouncil.domain.youthcouncil.modules.Idea;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IdeaRepository extends JpaRepository<Idea, Long> {
}
