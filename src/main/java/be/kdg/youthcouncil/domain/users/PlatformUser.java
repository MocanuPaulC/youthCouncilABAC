package be.kdg.youthcouncil.domain.users;

import be.kdg.youthcouncil.domain.youthcouncil.interactions.Reaction;
import be.kdg.youthcouncil.domain.youthcouncil.interactions.Share;
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
@ToString (exclude = {"reactions", "shares", "youthCouncilSubscriptions", "actionPointSubscriptions", "blockedYouthCouncils", "ideas"})
@EqualsAndHashCode (exclude = {"reactions", "shares", "youthCouncilSubscriptions", "actionPointSubscriptions", "blockedYouthCouncils", "ideas"})
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
	@OneToMany(fetch = FetchType.LAZY)
	private List<Reaction> reactions;
	@OneToMany(fetch = FetchType.LAZY)
	private List<Share> shares;
	@OneToMany(fetch = FetchType.LAZY)
	private List<YouthCouncilSubscription> youthCouncilSubscriptions;
	@OneToMany(fetch = FetchType.LAZY)
	private List<ActionPointSubscription> actionPointSubscriptions;
	@OneToMany(fetch = FetchType.LAZY)
	private List<BlockedUser> blockedYouthCouncils;
	@OneToMany(fetch = FetchType.LAZY)
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
