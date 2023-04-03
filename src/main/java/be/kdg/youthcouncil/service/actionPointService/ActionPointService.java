package be.kdg.youthcouncil.service.actionPointService;

import be.kdg.youthcouncil.controllers.api.dto.EditActionPointDto;

public interface ActionPointService {

	EditActionPointDto update(long actionPointId, long youthCouncilId, EditActionPointDto editActionPointDto);

	EditActionPointDto updateDefault(long actionPointId, EditActionPointDto editActionPointDto);
}
