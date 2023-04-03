package be.kdg.youthcouncil.domain.youthcouncil;

import be.kdg.youthcouncil.domain.media.Image;
import be.kdg.youthcouncil.domain.youthcouncil.modules.ActionPoint;
import be.kdg.youthcouncil.domain.youthcouncil.modules.Announcement;
import be.kdg.youthcouncil.domain.youthcouncil.modules.InformativePage;
import be.kdg.youthcouncil.domain.youthcouncil.subscriptions.BlockedUser;
import be.kdg.youthcouncil.domain.youthcouncil.subscriptions.YouthCouncilSubscription;
import be.kdg.youthcouncil.exceptions.ActionPointNotFound;
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
@Table (name = "youth_councils")
public class YouthCouncil {

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private long youthCouncilId;
	private String councilName;
	private String municipality;
	private String description;
	@OneToOne
	private Image councilLogo;
	private boolean isAfterElection;
	@OneToMany (fetch = FetchType.LAZY)
	private List<YouthCouncilSubscription> subscriptions;
	@OneToMany (fetch = FetchType.LAZY)
	private List<Announcement> announcements;
	@OneToMany (fetch = FetchType.LAZY)
	private List<InformativePage> informativePages;
	@OneToMany (fetch = FetchType.LAZY)
	private List<ActionPoint> actionPoints;

	@OneToMany (fetch = FetchType.LAZY)
	private List<BlockedUser> blockedUsers;

	public YouthCouncil(String councilName, String municipality, String description, Image councilLogo, boolean isAfterElection) {
		this.councilName = councilName;
		this.municipality = municipality;
		this.description = description;
		this.councilLogo = councilLogo;
		this.isAfterElection = isAfterElection;
	}

	public void addInformativePage(InformativePage informativePage) {
		informativePages.add(informativePage);
	}

	public ActionPoint getActionPoint(long id) {
		return actionPoints.stream()
		                   .filter(item -> item.getActionPointId() == id)
		                   .findFirst()
		                   .orElseThrow(() -> {throw new ActionPointNotFound(id);});
	}
}