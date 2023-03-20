package be.kdg.youthcouncil.persistence.youthcouncil;

import be.kdg.youthcouncil.domain.youthcouncil.YouthCouncil;
import be.kdg.youthcouncil.domain.youthcouncil.subscriptions.YouthCouncilSubscription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface YouthCouncilRepository extends JpaRepository<YouthCouncil, Long> {

	@Query ("select yc from YouthCouncil yc where yc.municipality = (:municipality)")
	YouthCouncil findByMunicipalityName(String municipality);

	@Query (
			"SELECT yc FROM YouthCouncil yc " +
					"JOIN FETCH yc.informativePages " +
					"WHERE yc.municipality = (:municipality)"
	)
	Optional<YouthCouncil> getWithInformativePages(String municipality);


	@Query (
			"SELECT yc from YouthCouncil yc " +
					"JOIN FETCH yc.actionPoints " +
					"WHERE yc.municipality = :municipality"
	)
	Optional<YouthCouncil> findWithActionPoints(String municipality);

	/*
	Original Query
	@Query (
			"SELECT y FROM YouthCouncil y " +
					"JOIN FETCH y.councilMembers " +
					"WHERE y.municipality = (:municipality)"
	)*/
	@Query (
			"select s from YouthCouncilSubscription s " +
					"join fetch s.subscriber " +
					"where s.youthCouncil.municipality = :municipality"
	)
	List<YouthCouncilSubscription> findSubscribersByMunicipality(String municipality);

	@Query (
			"SELECT s FROM YouthCouncilSubscription s " +
					"JOIN FETCH s.subscriber " +
					"WHERE s.youthCouncil.municipality = :municipality " +
					"AND s.role = 0"
	)
	YouthCouncil findAdminsByMunicipality(String municipality);

}
