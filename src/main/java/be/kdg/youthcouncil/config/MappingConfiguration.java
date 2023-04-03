package be.kdg.youthcouncil.config;

import be.kdg.youthcouncil.controllers.api.dto.IdeaDTO;
import be.kdg.youthcouncil.controllers.api.dto.NewIdeaDTO;
import be.kdg.youthcouncil.domain.youthcouncil.modules.Idea;
import be.kdg.youthcouncil.exceptions.CallForIdeaNotFoundException;
import be.kdg.youthcouncil.exceptions.SubThemeNotFoundException;
import be.kdg.youthcouncil.exceptions.UserNotFoundException;
import be.kdg.youthcouncil.persistence.CallForIdeaRepository;
import be.kdg.youthcouncil.persistence.users.UserRepository;
import be.kdg.youthcouncil.persistence.youthcouncil.modules.themes.SubThemeRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@AllArgsConstructor
@Configuration
public class MappingConfiguration {

	private final UserRepository userRepository;
	private final CallForIdeaRepository callForIdeaRepository;
	private final SubThemeRepository subThemeRepository;

	@Bean
	public ModelMapper modelMapper() {
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.createTypeMap(NewIdeaDTO.class, Idea.class)
		           .addMapping(ideaDTO -> userRepository.findById(ideaDTO.getUserId())
		                                                .orElseThrow(() -> new UserNotFoundException("The user could not be found!")), Idea::setUser)
		           .addMapping(ideaDTO -> callForIdeaRepository.findById(ideaDTO.getCallForIdeasId())
		                                                       .orElseThrow(() -> new CallForIdeaNotFoundException(ideaDTO.getCallForIdeasId())), Idea::setCallForIdeas)
		           .addMapping(ideaDTO -> subThemeRepository.findById(ideaDTO.getSubThemeId())
		                                                    .orElseThrow(() -> new SubThemeNotFoundException(ideaDTO.getSubThemeId())), Idea::setSubTheme);
		modelMapper.createTypeMap(Idea.class, IdeaDTO.class)
		           .addMapping(idea -> idea.getImage().getPath(), IdeaDTO::setImagePath)
		           .addMapping(idea -> idea.getUser().getUsername(), IdeaDTO::setUsername);

		return modelMapper;
	}


}
