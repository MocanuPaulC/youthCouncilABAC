package be.kdg.youthcouncil.domain.youthcouncil.interactions;

import be.kdg.youthcouncil.domain.media.Image;
import be.kdg.youthcouncil.domain.users.PlatformUser;
import be.kdg.youthcouncil.domain.youthcouncil.modules.Idea;
import lombok.*;

import javax.persistence.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table (name = "idea_shares", uniqueConstraints = {@UniqueConstraint (columnNames = {"idea_shared", "sharing_user"})})
@EqualsAndHashCode ()
public class IdeaShare {


	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private long ideaShareId;

	@OneToOne
	@JoinColumn (name = "idea_shared", nullable = false)
	private Idea sharedIdea;

	@OneToOne
	private Image image;

	@OneToOne
	@JoinColumn (name = "sharing_user", nullable = false)
	private PlatformUser platformUser;
}
