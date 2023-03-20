package be.kdg.youthcouncil.persistence.youthcouncil.subscriptions;

import be.kdg.youthcouncil.domain.youthcouncil.subscriptions.ActionPointSubscription;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActionPointSubscriptionRepository extends JpaRepository<ActionPointSubscription, Long> {
}
