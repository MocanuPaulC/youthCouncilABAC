package be.kdg.youthcouncil.persistence;

import be.kdg.youthcouncil.domain.youthcouncil.YouthCouncil;
import be.kdg.youthcouncil.domain.youthcouncil.modules.ActionPoint;
import be.kdg.youthcouncil.domain.youthcouncil.subscriptions.YouthCouncilSubscription;
import be.kdg.youthcouncil.persistence.youthcouncil.YouthCouncilRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

@SpringBootTest
public class YouthCouncilRepositoryTest {

	@Autowired
	private YouthCouncilRepository youthCouncilRepository;

	@Autowired
	private MediaRepository mediaRepository;


	@BeforeEach
	public void beforeEeach() {

	}

	@Test
	@Transactional
	public void findAllFindsAll() {
		YouthCouncilSubscription subscription = new YouthCouncilSubscription();

		List<YouthCouncil> list = youthCouncilRepository.findAll();
		assertEquals(1, list.size());
	}

	@Test
	public void findYouthCouncilReturnsWithoutActionPoints() {
		YouthCouncil youthCouncil = youthCouncilRepository.findById(1L).get();
		System.out.println(youthCouncil.getActionPoints().get(0).getTitle());
	}

	@Test
	public void findYouthCouncilWithActionPointsReturnsWithActionPoints() {
		String municipality = youthCouncilRepository.findById(1L).get().getMunicipality();
		System.out.println(municipality);
		YouthCouncil youthCouncil = youthCouncilRepository.findWithActionPoints(municipality).get();
		assertSame(youthCouncil.getActionPoints().get(0).getClass(), ActionPoint.class);

	}


}
