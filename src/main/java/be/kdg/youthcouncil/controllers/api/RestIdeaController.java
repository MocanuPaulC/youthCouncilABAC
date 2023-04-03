package be.kdg.youthcouncil.controllers.api;

import be.kdg.youthcouncil.controllers.api.dto.IdeaDTO;
import be.kdg.youthcouncil.controllers.api.dto.NewIdeaDTO;
import be.kdg.youthcouncil.domain.youthcouncil.modules.Idea;
import be.kdg.youthcouncil.service.callForIdeaService.CallForIdeaService;
import be.kdg.youthcouncil.service.callForIdeaService.IdeaService;
import be.kdg.youthcouncil.service.userService.UserService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@AllArgsConstructor
@Getter
@Setter
@RequestMapping ("/api/ideas")
public class RestIdeaController {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	private final ModelMapper modelMapper;
	private final IdeaService ideaService;
	private final UserService userService;
	private final CallForIdeaService callForIdeaService;

	//@PostMapping ("/{userId}/{callForIdeaId}") //TODO check that this path is updated everywher
	@PostMapping
	public ResponseEntity<IdeaDTO> answerCFI(@Valid @RequestBody NewIdeaDTO newIdeaDTO) {

		return ResponseEntity.ok()
		                     .body(modelMapper.map(ideaService.createIdea(modelMapper.map(newIdeaDTO, Idea.class)), IdeaDTO.class));

	}


}
