package be.kdg.youthcouncil.persistence;

import be.kdg.youthcouncil.domain.moduleItems.ActionPoint;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ActionPointRepository extends JpaRepository<ActionPoint, Long> {
}
