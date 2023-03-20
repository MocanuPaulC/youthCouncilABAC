package be.kdg.youthcouncil.persistence.youthcouncil.modules.themes;

import be.kdg.youthcouncil.domain.youthcouncil.modules.themes.Theme;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ThemeRepository extends JpaRepository<Theme, Long> {
}
