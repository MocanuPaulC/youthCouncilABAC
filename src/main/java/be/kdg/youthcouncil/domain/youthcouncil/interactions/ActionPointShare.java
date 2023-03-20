package be.kdg.youthcouncil.domain.youthcouncil.interactions;

import be.kdg.youthcouncil.domain.media.Image;
import be.kdg.youthcouncil.domain.users.PlatformUser;
import be.kdg.youthcouncil.domain.youthcouncil.modules.ActionPoint;
import lombok.*;

import javax.persistence.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table (name = "action_point_shares", uniqueConstraints = {@UniqueConstraint (columnNames = {"action_point_shared", "sharing_user"})})
@EqualsAndHashCode ()
public class ActionPointShare {

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private long actionPointShareId;

	@OneToOne
	@JoinColumn (name = "action_point_shared", nullable = false)
	private ActionPoint sharedActionPoint;

	@OneToOne
	private Image image;

	@OneToOne
	@JoinColumn (name = "sharing_user", nullable = false)
	private PlatformUser platformUser;

}
