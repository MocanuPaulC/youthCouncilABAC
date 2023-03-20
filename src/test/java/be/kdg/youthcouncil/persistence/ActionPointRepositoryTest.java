package be.kdg.youthcouncil.persistence;

import be.kdg.youthcouncil.domain.youthcouncil.interactions.Share;
import be.kdg.youthcouncil.domain.youthcouncil.modules.ActionPoint;
import be.kdg.youthcouncil.persistence.youthcouncil.YouthCouncilRepository;
import be.kdg.youthcouncil.persistence.youthcouncil.modules.ActionPointRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class ActionPointRepositoryTest {

	@Autowired
	private ActionPointRepository actionPointRepository;

	@Autowired
	private YouthCouncilRepository youthCouncilRepository;

	@Test
	public void findActionPointOfShare() {
		ActionPoint actionPoint = actionPointRepository.findById(1L).get();
		List<Share> shares = actionPointRepository.findWithShares(actionPoint).getShares();
		assertEquals(actionPoint, shares.get(0).getItemShared());
	}
}
