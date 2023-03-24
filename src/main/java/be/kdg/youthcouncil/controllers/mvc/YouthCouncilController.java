package be.kdg.youthcouncil.controllers.mvc;


import be.kdg.youthcouncil.config.security.annotations.CAOnly;
import be.kdg.youthcouncil.config.security.annotations.GAOnly;
import be.kdg.youthcouncil.controllers.mvc.viewModels.*;
import be.kdg.youthcouncil.domain.moduleItems.ActionPoint;
import be.kdg.youthcouncil.domain.moduleItems.Label;
import be.kdg.youthcouncil.domain.youthCouncil.InformativePage;
import be.kdg.youthcouncil.domain.youthCouncil.YouthCouncil;
import be.kdg.youthcouncil.service.informativePageService.InformativePageService;
import be.kdg.youthcouncil.service.userService.UserService;
import be.kdg.youthcouncil.service.youthCouncilService.YouthCouncilService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping ("/youthcouncils")
public class YouthCouncilController {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	private final ModelMapper modelMapper;

	private final YouthCouncilService youthCouncilService;
	private final UserService userService;

	private final InformativePageService informativePageService;

	@GetMapping ()
	public String youthCouncils(Model model) {
		model.addAttribute("councils", youthCouncilService.findAllYouthCouncils());
		return "youthCouncils";
	}

	@GAOnly
	@GetMapping ("/add")
	public String getAddYouthCouncil(Model model) {
		model.addAttribute("youthCouncil", new NewYouthCouncilViewModel());
		return "addYouthCouncil";
	}

	@GAOnly
	@PostMapping ("/add")
	public String addYouthCouncil(@Valid @ModelAttribute ("youthCouncil") NewYouthCouncilViewModel viewModel, BindingResult errors, HttpServletRequest request) {
		logger.debug(viewModel.toString() + " in postMapping of addYouthCouncil");
		if (errors.hasErrors()) {
			return "addYouthCouncil";
		}
		youthCouncilService.create(viewModel);
		return "redirect:/youthcouncils";
	}

	@GetMapping ("/{municipality}")
	public String youthCouncil(Model model, @PathVariable String municipality) {
		model.addAttribute("youthCouncil", youthCouncilService.findByMunicipality(municipality));
		return "youthCouncil";
	}

	@GetMapping ("/{municipality}/statistics")
	public String youthCouncilStatistics(Model model, @PathVariable String municipality) {
		var possibleYouthCouncil = youthCouncilService.findByMunicipality(municipality);
		model.addAttribute("youthCouncil", possibleYouthCouncil);
		model.addAttribute("users", youthCouncilService.getAllMembers(municipality));

		return "statistics";
	}

	@GetMapping ("/{municipality}/create-council-admin")
	public String getCreateCouncilAdmin(@PathVariable String municipality, Model model) {

		model.addAttribute("council", youthCouncilService.findByMunicipality(municipality));
		model.addAttribute("councilAdmin", new CouncilAdminViewModel());
		return "createCouncilAdmin";
	}

	@PostMapping ("/{municipality}/create-council-admin")
	public String createCouncilAdmin(
			@PathVariable String municipality,
			Model model,
			@Valid @ModelAttribute ("councilAdmin") CouncilAdminViewModel viewModel,
			BindingResult errors,
			HttpServletRequest request) {

		if (errors.hasErrors()) {

			return "createCouncilAdmin";
		} else {
			UserRegisterViewModel userRegisterViewModel = new UserRegisterViewModel();
			userRegisterViewModel.setEmail(viewModel.getEmail());
			userRegisterViewModel.setUsername(viewModel.getEmail());
			userRegisterViewModel.setPassword(viewModel.getPassword());
			userService.save(userRegisterViewModel);
		}

		return "redirect:/";
	}


	@CAOnly
	@GetMapping ("/{municipality}/informativepages")
	public String informativePages(Model model, @PathVariable String municipality) {
		List<InformativePage> pages = youthCouncilService.getAllInformativePages(municipality);
		model.addAttribute("informativePages", pages);
		return "informativePages";
	}

	@CAOnly
	@GetMapping ("/{municipality}/informativepages/add")
	public String getAddInformativePage(Model model, @PathVariable String municipality) {
		model.addAttribute("informativePage", new NewInformativePageViewModel());
		model.addAttribute("youthCouncilId", municipality);
		return "addInformativePage";
	}


	@GetMapping ("/{municipality}/actionpoints/{actionpointid}")
	public String getActionPointsOfYouthCouncil(@PathVariable String municipality, @PathVariable long actionpointid, Model model) {

		YouthCouncil youthCouncil = youthCouncilService.findByMunicipality(municipality);
		try {
			model.addAttribute("actionPoint", youthCouncil.getActionPoint(actionpointid, ActionPoint.class));
			model.addAttribute("labels", Label.values());
		} catch (RuntimeException e) {
			e.printStackTrace();
			//			model.addAttribute("youthCouncil", youthCouncil);
			return "redirect:/";
		}
		model.addAttribute("youthCouncil", youthCouncil);
		model.addAttribute("actionPointModelView", new EditActionPointModelView());

		return "actionPoint";


	}

	@CAOnly
	@PostMapping ("/{municipality}/informativepages/add")
	public String addInformativePage(@PathVariable String municipality, @Valid @ModelAttribute ("informativePage") NewInformativePageViewModel viewModel, BindingResult errors) {
		logger.debug(viewModel.toString() + " in postMapping of addInformationalPage");
		if (errors.hasErrors()) {
			return "addInformativePage";
		}
		informativePageService.save(municipality, viewModel);
		return "redirect:/youthcouncils/" + municipality + "/informativepages";
	}
}
