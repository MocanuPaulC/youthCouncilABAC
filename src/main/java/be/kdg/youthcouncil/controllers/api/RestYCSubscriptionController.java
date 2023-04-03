package be.kdg.youthcouncil.controllers.api;

import be.kdg.youthcouncil.domain.youthcouncil.YouthCouncil;
import be.kdg.youthcouncil.service.callForIdeaService.CallForIdeaService;
import be.kdg.youthcouncil.service.userService.UserService;
import be.kdg.youthcouncil.service.youthCouncilService.YouthCouncilService;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@AllArgsConstructor
@RestController
@RequestMapping ("/api/ycsubscriptions")
public class RestYCSubscriptionController {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	private final YouthCouncilService youthCouncilService;
	private final CallForIdeaService callForIdeaService;

	private final UserService userService;

	@PostMapping ()
	public void addSubscription(@Valid @RequestBody ) {

		logger.debug("Adding user +" + model.getAttribute("authUser") + " to youth council " + youthCouncilId);
		YouthCouncil youthCouncil = youthCouncilService.findByIdWithMembers(youthCouncilId);
		youthCouncil.addCouncilMember(userService.findById(userId));
		youthCouncilService.save(youthCouncil);
	}

}
