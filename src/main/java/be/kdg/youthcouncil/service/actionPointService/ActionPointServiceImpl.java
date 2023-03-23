package be.kdg.youthcouncil.service.actionPointService;

import be.kdg.youthcouncil.domain.moduleItems.ActionPoint;
import be.kdg.youthcouncil.domain.moduleItems.Label;
import be.kdg.youthcouncil.persistence.ActionPointRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActionPointServiceImpl implements ActionPointService {
	private final ActionPointRepository repository;

	public ActionPointServiceImpl(ActionPointRepository repository) {
		this.repository = repository;
	}

	@Override
	public List<ActionPoint> getAllActionPoints() {
		ActionPoint a = new ActionPoint();
		a.setLabel(Label.IN_PROGRESS);
		ActionPoint b = new ActionPoint();
		b.setLabel(Label.INCLUDED);
		ActionPoint c = new ActionPoint();
		c.setLabel(Label.NOT_INCLUDED);
		repository.save(a);
		repository.save(b);
		repository.save(c);
		return repository.findAll();
	}

	@Override
	public ActionPoint findActionPointById(long id) {
		return repository.getReferenceById(id);
	}

	@Override
	public List<ActionPoint> searchByLabel(String pattern) {
		return getAllActionPoints().stream()
		                           .filter(actionPoint -> actionPoint.getLabel()
		                                                             .name()
		                                                             .compareToIgnoreCase(pattern) > 0)
		                           .toList();
	}
}
