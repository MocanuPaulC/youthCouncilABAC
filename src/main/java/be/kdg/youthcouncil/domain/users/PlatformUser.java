package be.kdg.youthcouncil.domain.users;

import be.kdg.youthcouncil.domain.youthcouncil.interactions.ActionPointReaction;
import be.kdg.youthcouncil.domain.youthcouncil.interactions.ActionPointShare;
import be.kdg.youthcouncil.domain.youthcouncil.interactions.IdeaReaction;
import be.kdg.youthcouncil.domain.youthcouncil.interactions.IdeaShare;
import be.kdg.youthcouncil.domain.youthcouncil.modules.Idea;
import be.kdg.youthcouncil.domain.youthcouncil.subscriptions.ActionPointSubscription;
import be.kdg.youthcouncil.domain.youthcouncil.subscriptions.BlockedUser;
import be.kdg.youthcouncil.domain.youthcouncil.subscriptions.YouthCouncilSubscription;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString (exclude = {"actionPointReactions", "actionPointShares", "ideaReactions", "ideaShares", "youthCouncilSubscriptions", "actionPointSubscriptions", "blockedYouthCouncils", "ideas"})
@EqualsAndHashCode (exclude = {"actionPointReactions", "actionPointShares", "ideaReactions", "ideaShares", "youthCouncilSubscriptions", "actionPointSubscriptions", "blockedYouthCouncils", "ideas"})
@Entity
@Table (name = "platform_users")
public class PlatformUser implements Authenticable {

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Getter (AccessLevel.NONE)
	private long userId;
	private String firstName;
	private String lastName;
	private String email;
	private String postcode;
	@Getter (AccessLevel.NONE)
	@Column (unique = true)
	private String username;
	@Getter (AccessLevel.NONE)
	private String password;
	@Getter (AccessLevel.NONE)
	private AuthenticationType authenticationType;
	@OneToMany (fetch = FetchType.LAZY)
	private List<ActionPointReaction> actionPointReactions;
	@OneToMany (fetch = FetchType.LAZY)
	private List<ActionPointShare> actionPointShares;

	@OneToMany (fetch = FetchType.LAZY)
	private List<IdeaReaction> ideaReactions;
	@OneToMany (fetch = FetchType.LAZY)
	private List<IdeaShare> ideaShares;
	@OneToMany (fetch = FetchType.LAZY)
	private List<YouthCouncilSubscription> youthCouncilSubscriptions;
	@OneToMany (fetch = FetchType.LAZY)
	private List<ActionPointSubscription> actionPointSubscriptions;
	@OneToMany (fetch = FetchType.LAZY)
	private List<BlockedUser> blockedYouthCouncils;
	@OneToMany (fetch = FetchType.LAZY)
	private List<Idea> ideas;

	public PlatformUser(String firstName, String lastName, String email, String postcode, String username, String password) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.postcode = postcode;
		this.username = username;
		this.password = password;
	}

	@Override
	public long getId() {
		return userId;
	}

	@Override
	public boolean isGA() {
		return false;
	}

	@Override
	public String getUsername() {
		return username;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public AuthenticationType getAuthenticationType() {
		return authenticationType;
	}
}
