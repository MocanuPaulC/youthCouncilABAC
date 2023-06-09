package be.kdg.youthcouncil.controllers.api;

import be.kdg.youthcouncil.controllers.api.dto.CallForIdeasDTO;
import be.kdg.youthcouncil.domain.youthCouncil.YouthCouncil;
import be.kdg.youthcouncil.service.callForIdeaService.CallForIdeaService;
import be.kdg.youthcouncil.service.userService.UserService;
import be.kdg.youthcouncil.service.youthCouncilService.YouthCouncilService;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@AllArgsConstructor
@RestController
@RequestMapping ("/api/youthcouncils")
public class RestYouthCouncilController {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	private final YouthCouncilService youthCouncilService;
	private final CallForIdeaService callForIdeaService;

	private final UserService userService;


	@PatchMapping ("/{youthCouncilId}/{userId}")
	public void addMemeberToYouthCouncil(Model model, @PathVariable long youthCouncilId, @PathVariable long userId) {

		logger.debug("Adding user +" + model.getAttribute("authUser") + " to youth council " + youthCouncilId);
		YouthCouncil youthCouncil = youthCouncilService.findByIdWithMembers(youthCouncilId);
		youthCouncil.addCouncilMember(userService.findById(userId));
		youthCouncilService.save(youthCouncil);
	}

	@PostMapping ("/{id}/callforideas")
	public ResponseEntity<CallForIdeasDTO> launchCallForIdeas(@PathVariable Long id, @Valid @RequestBody CallForIdeasDTO callForIdeasDTO) {
		callForIdeaService.create(callForIdeasDTO);
		return ResponseEntity.ok(callForIdeasDTO);
	}

	//TODO: implement
	//    @GetMapping
	//    public ResponseEntity<ActionPointDTO> getFilteredActionPoints(){
	//        return null;
	//    }

}
