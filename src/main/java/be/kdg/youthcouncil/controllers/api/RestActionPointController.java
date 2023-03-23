package be.kdg.youthcouncil.controllers.api;

import be.kdg.youthcouncil.controllers.api.dto.ActionPointDto;
import be.kdg.youthcouncil.service.actionPointService.ActionPointService;
//import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("/api/actionPoints")
public class RestActionPointController {
//	private ModelMapper modelMapper;
	private ActionPointService actionPointService;

	public RestActionPointController(ActionPointService actionPoint) {
		this.actionPointService = actionPoint;
	}

	@GetMapping("/{actionPointID}")
	public ResponseEntity<ActionPointDto> retrieveActionPoint(@PathVariable ("actionPointID") int actionPointID) {
		var actionPoint = actionPointService.findActionPointById(actionPointID);
		if (actionPoint == null) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<>(new ActionPointDto(actionPoint.getSubTheme(), actionPoint.getLabel(), actionPoint.getIdeaList(), actionPoint.getImages(), actionPoint.getVideos()), HttpStatus.OK);
		}
	}


	@GetMapping
	public ResponseEntity<List<ActionPointDto>> searchActionPointByLabel(@RequestParam String searchValue) {
		var actionPoints = actionPointService.searchByLabel(searchValue);
		System.out.println(actionPoints);
		if (actionPoints.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<>(
					actionPoints.stream().map(actionPoint -> new ActionPointDto(
							actionPoint.getSubTheme(),
							actionPoint.getLabel(),
							actionPoint.getIdeaList(),
							actionPoint.getImages(),
							actionPoint.getVideos())).toList(),
					HttpStatus.OK);
		}
	}
}
