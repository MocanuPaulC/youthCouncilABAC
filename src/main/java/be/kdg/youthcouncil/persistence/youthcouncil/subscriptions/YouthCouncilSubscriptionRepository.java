package be.kdg.youthcouncil.persistence.youthcouncil.subscriptions;

import be.kdg.youthcouncil.domain.youthcouncil.subscriptions.YouthCouncilSubscription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface YouthCouncilSubscriptionRepository extends JpaRepository<YouthCouncilSubscription, Long> {

	@Query (
			"SELECT s FROM YouthCouncilSubscription s " +
					"JOIN FETCH s.youthCouncil " +
					"WHERE s.youthCouncilSubscriptionId = :subscriptionId"
	)
	Optional<YouthCouncilSubscription> findWithYouthCouncil(long subscriptionId);
}
