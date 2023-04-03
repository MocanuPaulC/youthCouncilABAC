package be.kdg.youthcouncil.controllers.api.dto;

import lombok.*;


@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class IdeaDTO {
	private String idea;
	private String imagePath;
	private String username;

}
