package be.kdg.youthcouncil.service.actionPointService;

import be.kdg.youthcouncil.domain.moduleItems.ActionPoint;

import java.util.List;

public interface ActionPointService {
	public List<ActionPoint> getAllActionPoints();
	public ActionPoint findActionPointById(long id);
	public List<ActionPoint> searchByLabel(String searchValue);
}
