package be.kdg.youthcouncil.controllers.api.dto;

import be.kdg.youthcouncil.domain.moduleItems.Idea;
import be.kdg.youthcouncil.domain.moduleItems.Label;
import be.kdg.youthcouncil.domain.moduleItems.SubTheme;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

public class ActionPointDto {


	private SubTheme subTheme;
	@Enumerated (EnumType.STRING)
	private Label label;

	private List<Idea> ideaList;


	private List<String> images;

	private List<String> videos;

	public ActionPointDto(SubTheme subTheme, Label label, List<Idea> ideaList, List<String> images, List<String> videos) {
		this.subTheme = subTheme;
		this.label = label;
		this.ideaList = ideaList;
		this.images = images;
		this.videos = videos;
	}

	public SubTheme getSubTheme() {
		return subTheme;
	}

	public void setSubTheme(SubTheme subTheme) {
		this.subTheme = subTheme;
	}

	public Label getLabel() {
		return label;
	}

	public void setLabel(Label label) {
		this.label = label;
	}

	public List<Idea> getIdeaList() {
		return ideaList;
	}

	public void setIdeaList(List<Idea> ideaList) {
		this.ideaList = ideaList;
	}

	public List<String> getImages() {
		return images;
	}

	public void setImages(List<String> images) {
		this.images = images;
	}

	public List<String> getVideos() {
		return videos;
	}

	public void setVideos(List<String> videos) {
		this.videos = videos;
	}
}
