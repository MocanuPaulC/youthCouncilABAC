package be.kdg.youthcouncil.controllers.mvc;

import be.kdg.youthcouncil.domain.moduleItems.ActionPoint;
import be.kdg.youthcouncil.domain.moduleItems.Label;
import be.kdg.youthcouncil.service.actionPointService.ActionPointService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping ("/actionPoints")
public class ActionPointController {
	private final ActionPointService actionPointService;

	public ActionPointController(ActionPointService actionPoint) {
		this.actionPointService = actionPoint;
	}

	@GetMapping
	public String showActionPoints(Model model) {
		//for test purpose, will use actual value later
		model.addAttribute("allActionPoints", actionPointService.getAllActionPoints());
		return "action_point";
	}

}
