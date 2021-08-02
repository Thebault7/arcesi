package com.arcesi.arcesi.model;

import java.io.Serializable;

/**
 * 
 * @author Frédéric Thébault
 * @version 1.0
 *
 */
public class Video implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String title;
	private String description;
	private String channel;
	private int durationInSeconds;
	private String urlLink;
	
	public Video() {
		super();
	}
	
	public Video(String title, String description, String channel, int durationInSeconds, String urlLink) {
		super();
		this.title = title;
		this.description = description;
		this.channel = channel;
		this.durationInSeconds = durationInSeconds;
		this.urlLink = urlLink;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getChannel() {
		return channel;
	}

	public void setChannel(String channel) {
		this.channel = channel;
	}

	public int getDurationInSeconds() {
		return durationInSeconds;
	}

	public void setDurationInSeconds(int durationInSeconds) {
		this.durationInSeconds = durationInSeconds;
	}

	public String getUrlLink() {
		return urlLink;
	}

	public void setUrlLink(String urlLink) {
		this.urlLink = urlLink;
	}
}
