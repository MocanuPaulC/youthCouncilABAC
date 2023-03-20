package be.kdg.youthcouncil.persistence.youthcouncil.modules;

import be.kdg.youthcouncil.domain.youthcouncil.modules.Announcement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnnouncementRepository extends JpaRepository<Announcement, Long> {

}
