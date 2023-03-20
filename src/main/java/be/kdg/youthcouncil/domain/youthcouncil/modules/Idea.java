package be.kdg.youthcouncil.domain.youthcouncil.modules;

import be.kdg.youthcouncil.domain.media.Image;
import be.kdg.youthcouncil.domain.users.PlatformUser;
import be.kdg.youthcouncil.domain.youthcouncil.interactions.IdeaReaction;
import be.kdg.youthcouncil.domain.youthcouncil.interactions.IdeaShare;
import be.kdg.youthcouncil.domain.youthcouncil.modules.themes.SubTheme;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table (name = "ideas")
public class Idea {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private long ideaId;

	private String idea;
	@ManyToOne
	private SubTheme theme;
	@OneToOne
	private Image image;
	@ManyToOne
	private PlatformUser owningUser;

	@ManyToOne
	private CallForIdea owningCallForIdeas;

	@OneToMany (fetch = FetchType.LAZY)
	private List<IdeaShare> shares;
	@OneToMany (fetch = FetchType.LAZY)
	private List<IdeaReaction> reactions;

	public Idea(String idea, SubTheme theme, Image image, PlatformUser owningUser, CallForIdea owningCallForIdeas) {
		this.idea = idea;
		this.theme = theme;
		this.image = image;
		this.owningUser = owningUser;
		this.owningCallForIdeas = owningCallForIdeas;
	}
}
