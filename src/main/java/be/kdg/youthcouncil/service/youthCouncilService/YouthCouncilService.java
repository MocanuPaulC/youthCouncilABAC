package be.kdg.youthcouncil.service.youthCouncilService;

import be.kdg.youthcouncil.controllers.mvc.viewModels.NewYouthCouncilViewModel;
import be.kdg.youthcouncil.domain.users.PlatformUser;
import be.kdg.youthcouncil.domain.youthcouncil.YouthCouncil;
import be.kdg.youthcouncil.domain.youthcouncil.modules.ActionPoint;
import be.kdg.youthcouncil.domain.youthcouncil.modules.InformativePage;

import java.util.List;

public interface YouthCouncilService {

	void create(NewYouthCouncilViewModel councilCreateModel);

	List<YouthCouncil> findAllYouthCouncils();

	List<ActionPoint> getFilteredActionPoints(String municipality, String theme, String label);


	List<PlatformUser> getAllMembers(String municipality);

	void save(YouthCouncil youthCouncil);

	YouthCouncil findByIdWithMembers(long id);

	YouthCouncil findById(long id);


	YouthCouncil getYouthCouncil(long id);

	YouthCouncil findByMunicipality(String municipality);


	List<InformativePage> getAllInformativePages(String municipality);
}
